import {config} from '../../config/config'


export const VOICE_CONTROL_ON = 'VOICE_CONTROL_ON';
export const VOICE_CONTROL_OFF = 'VOICE_CONTROL_OFF';

export const VOICE_CONTROL_START = 'VOICE_CONTROL_START';
export const VOICE_CONTROL_END = 'VOICE_CONTROL_END';
export const VOICE_CONTROL_ERROR = 'VOICE_CONTROL_ERROR';
export const VOICE_CONTROL_ABORT = 'VOICE_CONTROL_ABORT';
export const VOICE_CONTROL_SHOW_HELP = 'VOICE_CONTROL_SHOW_HELP';
export const VOICE_CONTROL_HIDE_HELP = 'VOICE_CONTROL_HIDE_HELP';


export const VOICE_CONTROL_MATCH = 'VOICE_CONTROL_MATCH';
export const VOICE_CONTROL_NO_MATCH = 'VOICE_CONTROL_NO_MATCH';

export const VOICE_CONTROL_ACTION = 'VOICE_CONTROL_ACTION';
export const VOICE_CONTROL_LAYOUT = 'VOICE_CONTROL_LAYOUT';
export const VOICE_CONTROL_NAVIGATE = 'VOICE_CONTROL_NAVIGATE';
export const VOICE_CONTROL_SOUND = 'VOICE_CONTROL_SOUND';
export const VOICE_CONTROL_VOICE = 'VOICE_CONTROL_VOICE';
export const VOICE_CONTROL_CALLBACK = 'VOICE_CONTROL_CALLBACK';

import store from '../../store/configureStore'



export function voiceControlOn() {
  return {
    type: VOICE_CONTROL_ON
  }
}


if(config.voice_command_auto){
  voiceControlOn()
}




export function voiceControlOff() {
  return {
    type: VOICE_CONTROL_OFF
  }
}


export function voiceControlNoMatch(commandText) {
  store.dispatch({
    type: VOICE_CONTROL_NO_MATCH,
    payload: commandText
  })
}


export function voiceControlMatch(command) {
  store.dispatch({
    type: VOICE_CONTROL_MATCH,
    payload: command
  })
}


export function voiceControlCommand(command) {
  store.dispatch(command)
}


export function voiceControlEnd(event) {
  return {
    type: VOICE_CONTROL_END,
    payload: event
  }
}

export function voiceControlError(event) {
  return {
    type: VOICE_CONTROL_ERROR,
    payload: event
  }
}

export function voiceControlAbort() {
  return {
    type: VOICE_CONTROL_ABORT
  }
}


export function voiceControlStart() {
  return {
    type: VOICE_CONTROL_START
  }
}
export function voiceControlShowHelp() {
  return {
    type: VOICE_CONTROL_SHOW_HELP
  }
}
export function voiceControlHideHelp() {
  return {
    type: VOICE_CONTROL_HIDE_HELP
  }
}

