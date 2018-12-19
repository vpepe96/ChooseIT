/**
 * Created by griga on 11/24/15.
 */


export const CHAT_INIT = 'CHAT_INIT';
export const CHAT_MESSAGE_TO = 'CHAT_MESSAGE_TO';
export const CHAT_MESSAGE_UPDATE = 'CHAT_MESSAGE_UPDATE';
export const CHAT_MESSAGE_SEND = 'CHAT_MESSAGE_SEND';

export function chatInit(){
  return dispatch => {
    return $.getJSON('assets/api/chat/chat.json')
      .then(data=>{
        dispatch({
          type: CHAT_INIT,
          data
        })
      })
  }
}

export function messageTo(user){
  return {
    type: CHAT_MESSAGE_TO,
    user
  }
}

export function messageUpdate(){
  return {
    type: CHAT_MESSAGE_UPDATE
  }
}

export function messageSend(message){
  return (dispatch, getState)=>{
    return dispatch({
      type: CHAT_MESSAGE_SEND,
      user: getState().user,
      message
    })
  }

}
