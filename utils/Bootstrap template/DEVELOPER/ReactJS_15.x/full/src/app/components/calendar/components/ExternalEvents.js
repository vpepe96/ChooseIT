import React from 'react'
import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'

import * as EventActions from '../EventActions'

import DraggableEvent from './DraggableEvent'

class ExternalEvents extends React.Component {

  render() {
    return (
      <form>
        <legend>
          Draggable Events
        </legend>
        <ul id="external-events" className="list-unstyled">
          {this.props.externalEvents.map((event, idx) => {
            return (<DraggableEvent event={event} key={idx}>
                                <span className={event.className}
                                      data-description={event.description}
                                      data-icon={event.icon}>
                                    {event.title}</span>
            </DraggableEvent>)
          })}
        </ul>
        <div className="checkbox">
          <label>
            <input type="checkbox" id="drop-remove" className="checkbox style-0"
                   defaultChecked={this.props.removeAfterDrop}
                   onClick={this.props.toggleRemoveOnDrop}/>
            <span>remove after drop</span>
          </label>
        </div>
      </form>
    )
  }
}

export default connect(
  (store)=>(store.events),
  (dispatch)=>(bindActionCreators(EventActions, dispatch))
)(ExternalEvents)