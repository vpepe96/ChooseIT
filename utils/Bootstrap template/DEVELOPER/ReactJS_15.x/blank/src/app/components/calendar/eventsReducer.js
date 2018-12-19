/**
 * Created by griga on 11/19/16.
 */

import {
  EVENTS_ADD_EXTERNAL,
  EVENTS_REMOVE_EXTERNAL,
  EVENTS_DROP_EXTERNAL,
  EVENTS_TOGGLE_REMOVE_ON_DROP,

} from './EventActions'

const initialState = {
  externalEvents: require('./data/external.js'),
  events: require('./data/events.js'),
  removeAfterDrop: false

};

export default function eventsReducer(state = initialState, action) {

  switch (action.type) {
    case EVENTS_ADD_EXTERNAL:
      return {
        ...state,
        externalEvents: [...state.externalEvents, action.event]
      };

    case EVENTS_REMOVE_EXTERNAL:
      let eventIdx = state.externalEvents.indexOf(action.event);
      return {
        ...state,
        externalEvents: [
          ...state.externalEvents.slice(0, eventIdx),
          ...state.externalEvents.slice(eventIdx + 1)
        ]
      };

    case EVENTS_DROP_EXTERNAL:
      return state;

    case EVENTS_TOGGLE_REMOVE_ON_DROP:
      state.removeAfterDrop = !state.removeAfterDrop;
      return state;

    default:
      return state
  }

}