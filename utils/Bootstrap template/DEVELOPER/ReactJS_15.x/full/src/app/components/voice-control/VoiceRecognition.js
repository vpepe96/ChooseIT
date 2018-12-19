import SpeechRecognition from './utils/SpeechRecognitionApi';
import {config} from '../../config/config'

import * as actions from './VoiceActions'

export class VoiceRecognition {

  commandsList = [];
  recognition = null;
  autoRestart = false;
  lastStartedAt = 0;

  constructor() {
    if (!this.commandsList.length) {
      this.addCommands(config.commands)
    }
  }


  callbacks = {
    start: [],
    error: [],
    end: [],
    result: [],
    resultMatch: [],
    resultNoMatch: [],
    errorNetwork: [],
    errorPermissionBlocked: [],
    errorPermissionDenied: []
  };


  commandToRegExp(command) {
    const optionalParam = /\s*\((.*?)\)\s*/g,
      optionalRegex = /(\(\?:[^)]+\))\?/g,
      namedParam = /(\(\?)?:\w+/g,
      splatParam = /\*\w+/g,
      escapeRegExp = /[\-{}\[\]+?.,\\\^$|#]/g;
    command = command.replace(escapeRegExp, '\\$&').replace(optionalParam, '(?:$1)?').replace(namedParam, (match, optional)=> {
      return optional ? match : '([^\\s]+)';
    }).replace(splatParam, '(.*?)').replace(optionalRegex, '\\s*$1?\\s*');
    return new RegExp('^' + command + '$', 'i');
  };


  isInitialized() {
    return !!this.recognition;
  };

  initIfNeeded(options = {}) {
    if (!this.isInitialized()) {
      this.init(options, false);
    }
  };


  // Initialize smartSpeechRecognition with a list of commands to recognize.
  // e.g. smartSpeechRecognition.init({'hello :name': helloFunction})
  // smartSpeechRecognition understands commands with named variables, splats, and optional words.

  init = (commands, resetCommands = true) => {

    let recognition = this.recognition;

    // Abort previous instances of recognition already running
    if (recognition && recognition.abort) {
      recognition.abort();
    }

    // initiate SpeechRecognition
    recognition = new SpeechRecognition();


    // Set the max number of alternative transcripts to try and match with a command
    recognition.maxAlternatives = 5;
    recognition.continuous = true;
    // Sets the language to the default 'en-US'. This can be changed with smartSpeechRecognition.setLanguage()
    recognition.lang = config.voice_command_lang || 'en-US';

    recognition.onstart = ()=> {
      // invokeCallbacks(callbacks.start);
      //debugState
      if (config.debugState) {
        console.log('%c ✔ SUCCESS: User allowed access the microphone service to start ', config.debugStyle_success);
        console.log('Language setting is set to: ' + recognition.lang, config.debugStyle);
      }


      actions.voiceControlStart();
    };

    recognition.onerror = (event) => {
      // this.invokeCallbacks(this.callbacks.error);
      switch (event.error) {
        case 'network':
          // this.invokeCallbacks(this.callbacks.errorNetwork);
          break;
        case 'not-allowed':
        case 'service-not-allowed':
          // if permission to use the mic is denied, turn off auto-restart
          this.autoRestart = false;
          //debugState
          if (config.debugState) {
            console.log('%c WARNING: Microphone was not detected (either user denied access or it is not installed properly) ', config.debugStyle_warning);
          }
          // determine if permission was denied by user or automatically.
          if (new Date().getTime() - this.lastStartedAt < 200) {
            // invokeCallbacks(callbacks.errorPermissionBlocked);
          } else {
            // invokeCallbacks(callbacks.errorPermissionDenied);
            //console.log("You need your mic to be active")
          }


          actions.voiceControlError(event)
          break;
      }
    };

    recognition.onend = () => {
      // invokeCallbacks(this.callbacks.end);
      // smartSpeechRecognition will auto restart if it is closed automatically and not by user action.

      actions.voiceControlEnd(event)

      if (this.autoRestart) {
        // play nicely with the browser, and never restart smartSpeechRecognition automatically more than once per second
        const timeSinceLastStart = new Date().getTime() - this.lastStartedAt;
        if (timeSinceLastStart < 1000) {
          setTimeout(()=> {
            this.start({})
          }, 1000 - timeSinceLastStart);
        } else {
          this.start({})
        }
      }
    };

    recognition.onresult = (event) => {

      // this.invokeCallbacks(this.callbacks.result);

      const results = event.results[event.resultIndex];
      let commandText;

      // go over each of the 5 results and alternative results received (we've set maxAlternatives to 5 above)
      for (let i = 0; i < results.length; i++) {
        // the text recognized
        commandText = results[i].transcript.trim();
        if (config.debugState) {
          console.log('Speech recognized: %c' + commandText, config.debugStyle);
        }

        // try and match recognized text to one of the commands on the list
        for (let j = 0, l = this.commandsList.length; j < l; j++) {
          const result = this.commandsList[j].command.exec(commandText);
          if (result) {
            const parameters = result.slice(1);
            if (config.debugState) {
              console.log('command matched: %c' + this.commandsList[j].originalPhrase, config.debugStyle);
              if (parameters.length) {
                console.log('with parameters', parameters);
              }
            }

            if (this.commandsList[j].type == actions.VOICE_CONTROL_ACTION) {

              actions.voiceControlCommand(this.commandsList[j])


            } else {
              // execute the matched command
              this.commandsList[j].callback.apply(this, parameters);
            }
            // this.invokeCallbacks(this.callbacks.resultMatch);


            // for commands "sound on", "stop" and "mute" do not play sound or display message
            const ignoreCallsFor = ["sound on", "mute", "stop"];

            if (ignoreCallsFor.indexOf(this.commandsList[j].originalPhrase) < 0) {

              actions.voiceControlMatch(this.commandsList[j].originalPhrase)
            }// end if

            return true;
          }
        } // end for
      }// end for

      // invokeCallbacks(callbacks.resultNoMatch);
      //console.log("no match found for: " + commandText)

      actions.voiceControlNoMatch(commandText);

      return false;
    };

    // build commands list
    if (resetCommands) {
      this.commandsList = [];
    }
    if (commands.length) {
      this.addCommands(commands);
    }

    this.recognition = recognition;
  };

  // Start listening (asking for permission first, if needed).
  // Call this after you've initialized smartSpeechRecognition with commands.
  // Receives an optional options object:
  // { autoRestart: true }
  start = (options = {}) => {
    this.initIfNeeded(options);
    if (options.autoRestart !== undefined) {
      this.autoRestart = !!options.autoRestart;
    } else {
      this.autoRestart = true;
    }


    this.lastStartedAt = new Date().getTime();

    this.recognition.start();
  }


  // abort the listening session (aka stop)
  abort = () => {
    this.autoRestart = false;
    if (this.recognition && this.recognition.abort) {
      this.recognition.abort();
    }
    actions.voiceControlAbort()
  }

  // Turn on output of debug messages to the console. Ugly, but super-handy!
  debug(newState) {
    if (arguments.length > 0) {
      config.debugState = !!newState;
    } else {
      config.debugState = true;
    }
  }

  // Set the language the user will speak in. If not called, defaults to 'en-US'.
  // e.g. 'fr-FR' (French-France), 'es-CR' (Español-Costa Rica)
  setLanguage(language) {
    this.initIfNeeded();
    this.recognition.lang = language;
  }

  // Add additional commands that smartSpeechRecognition will respond to. Similar in syntax to smartSpeechRecognition.init()
  addCommands = (commands) => {
    let action, command;

    this.initIfNeeded();

    Object.keys(commands).forEach((phrase)=> {
      action = window[commands[phrase]] || commands[phrase];
      //convert command to regex
      command = this.commandToRegExp(phrase);

      if (typeof action === 'function') {


        this.commandsList.push({
          type: actions.VOICE_CONTROL_CALLBACK,
          command: command,
          callback: action,
          originalPhrase: phrase
        });
      }
      if (typeof action === 'object') {
        this.commandsList.push({
          type: actions.VOICE_CONTROL_ACTION,
          command: command,
          payload: action.payload,
          actionType: action.type,
          originalPhrase: phrase
        });
      }
    });

    if (config.debugState) {
      console.log('Commands successfully loaded: %c' + this.commandsList.length, config.debugStyle);
    }
  }

  // Remove existing commands. Called with a single phrase, array of phrases, or methodically. Pass no params to remove all commands.
  removeCommands(commandsToRemove) {
    if (commandsToRemove === undefined) {
      this.commandsList = [];
      return;
    }
    commandsToRemove = Array.isArray(commandsToRemove) ? commandsToRemove : [commandsToRemove];
    this.commandsList = this.commandsList.filter((command) => {
      for (let i = 0; i < commandsToRemove.length; i++) {
        if (commandsToRemove[i] === command.originalPhrase) {
          return false;
        }
      }
      return true;
    });
  };

  // Lets the user add a callback of one of 9 types:
  // start, error, end, result, resultMatch, resultNoMatch, errorNetwork, errorPermissionBlocked, errorPermissionDenied
  // Can also optionally receive a context for the callback function as the third argument
  addCallback(type, callback, context) {
    if (this.callbacks[type] === undefined) {
      return;
    }
    var cb = window[callback] || callback;
    if (typeof cb !== 'function') {
      return;
    }
    this.callbacks[type].push({
      callback: cb,
      context: context || this
    });
  }


  invokeCallbacks(callbacks) {
    callbacks.forEach((callback) => {
      callback.callback.apply(callback.context);
    });
  };

}
