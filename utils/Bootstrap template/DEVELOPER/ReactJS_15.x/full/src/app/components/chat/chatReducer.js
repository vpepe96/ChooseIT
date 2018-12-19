/**
 * Created by griga on 11/17/16.
 */

import {CHAT_INIT, CHAT_MESSAGE_TO, CHAT_MESSAGE_UPDATE, CHAT_MESSAGE_SEND} from './ChatActions'

const initialState = {
  user: {},
  users: [],
  messages: [],
  message: ''
};

export default function chatReducer(state = initialState, action) {

  const _state = {...state};
  switch (action.type) {

    case CHAT_INIT:
      _state.messages = action.data.messages;
      _state.users = action.data.users;

      return _state;

    case CHAT_MESSAGE_TO:
      _state.message += action.user.username + ', ';
      return _state;

    case CHAT_MESSAGE_UPDATE:
      _state.message = action.message;
      return _state;

    case CHAT_MESSAGE_SEND:

      var message = {
        user: action.user,
        body: action.message,
        date: new Date()
      };
      _state.messages.push(message);
      _state.message = '';
      return _state;

    default:
      return state
  }
}