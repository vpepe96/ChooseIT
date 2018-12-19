import {config} from '../../config/config'
import SpeechRecognition from './utils/SpeechRecognitionApi'

import {VOICE_CONTROL_START, VOICE_CONTROL_ERROR, VOICE_CONTROL_OFF,
VOICE_CONTROL_SHOW_HELP, VOICE_CONTROL_HIDE_HELP, VOICE_CONTROL_ABORT,
} from './VoiceActions'

const startState = {
  enabled: !!config.voice_command,
  available: !!SpeechRecognition,
  autoStart: !!config.voice_command_auto,
  localStorage: !!config.voice_localStorage,
  lang: config.voice_command_lang,

  started: false,
  hasError: false,

  showHelp: false
};


export default function voiceControlReducer(state = startState, action) {
  switch (action.type) {

    case VOICE_CONTROL_START:
      return {
        ...state,
        started: true,
        hasError: false,
      };


    case VOICE_CONTROL_ERROR:

      return {
        ...state,
        started: false,
        hasError: true,
      };


    case VOICE_CONTROL_OFF: {
      return {
        ...state,
        started: false,
        hasError: false,
      }
    }

    case VOICE_CONTROL_ABORT: {
      return {
        ...state,
        started: false,
      }
    }

    case VOICE_CONTROL_SHOW_HELP: {
      return {

        ...state,
        showHelp: true
      }
    }

    case VOICE_CONTROL_HIDE_HELP: {
      return {
        ...state,
        showHelp: false,

      }
    }


    default:
      return state
  }
}