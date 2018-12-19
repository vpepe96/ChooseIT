/**
 * Created by griga on 12/8/15.
 */


import {
  OUTLOOK_INIT,
  OUTLOOK_FETCH_MESSAGE,
  OUTLOOK_FETCH_FOLDER,

} from './OutlookActions'


const initialState = {
  folders: [],
  labels: [],
  space: {},
  folder: {
    labels: []
  },
  message: {
    contact: {}
  },
  messages: []
};


export default function outlookReducer(state = initialState, action) {
  switch (action.type) {
    case OUTLOOK_INIT:
      return {
        ...state,
        folders: action.data.folders,
        space: action.data.space,
        labels: action.data.labels
      };

    case OUTLOOK_FETCH_FOLDER:
      return {
        ...state,
        folder: state.folders.find(it => it.key == action.key) || {labels: []},
        messages: action.data
      };

    case OUTLOOK_FETCH_MESSAGE:
      return {
        ...state,
        message: action.data
      };

    default:
      return state
  }
}


