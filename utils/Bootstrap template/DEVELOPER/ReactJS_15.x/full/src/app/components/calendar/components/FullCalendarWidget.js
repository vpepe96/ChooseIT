import React from 'react'
import {DropdownButton, MenuItem} from 'react-bootstrap'

import {connect} from 'react-redux';

import {bindActionCreators} from 'redux'

import * as EventActions from '../EventActions'

import JarvisWidget from '../../../components/widgets/JarvisWidget'

import 'script-loader!smartadmin-plugins/bower_components/fullcalendar/dist/fullcalendar.js'
import './FullCalendarWidget.css'

class FullCalendarWidget extends React.Component {

  componentDidMount() {
    this.preRender()
  }

  preRender() {
    const self = this;
    const $calendar = $(this.refs.smartCalendar);
    const calendar = $calendar.fullCalendar({
      lang: 'en',
      editable: true,
      draggable: true,
      selectable: false,
      selectHelper: true,
      unselectAuto: false,
      disableResizing: false,
      droppable: true,

      header: {
        left: 'title', //,today
        center: 'prev, next, today',
        right: 'month, agendaWeek, agendaDay' //month, agendaDay,
      },

      drop (date, allDay) { // this function is called when something is dropped

        // retrieve the dropped element's stored Event Object
        const originalEventObject = $(this).data('eventObject');

        // we need to copy it, so that multiple events don't have a reference to the same object
        const copiedEventObject ={...originalEventObject};

        // assign it the date that was reported
        copiedEventObject.start = date;
        copiedEventObject.allDay = allDay;

        // render the event on the calendar
        // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
        $calendar.fullCalendar('renderEvent', copiedEventObject, true);

        self.props.dropExternal(originalEventObject)



      },

      select (start, end, allDay) {
        var title = prompt('Event Title:');
        if (title) {
          calendar.fullCalendar('renderEvent', {
              title: title,
              start: start,
              end: end,
              allDay: allDay
            }, true // make the event "stick"
          );
        }
        calendar.fullCalendar('unselect');
      },


      events: (start, end, timezone, callback) => {
        callback(this.props.events);
      },

      eventRender (event, element, icon) {
        if (!event.description == "") {
          element.find('.fc-event-title').append("<br/><span class='ultra-light'>" + event.description + "</span>");
        }
        if (!event.icon == "") {
          element.find('.fc-event-title').append("<i class='air air-top-right fa " + event.icon + " '></i>");
        }
      }
    });

    $('.fc-header-right, .fc-header-center', $calendar).hide();
    $('.fc-left', $calendar).addClass('fc-header-title')
  }

  changeView  = (period)=> {
    $(this.refs.smartCalendar).fullCalendar('changeView', period);
  };

  next = ()=> {
    $('.fc-next-button', this.refs.smartCalendar).click();
  };

  prev = ()=> {
    $('.fc-prev-button', this.refs.smartCalendar).click();
  };

  today = ()=> {
    $('.fc-today-button', this.refs.smartCalendar).click();
  };



  render() {
    return (
      <JarvisWidget color="blueDark">
        <header>
          <span className="widget-icon"> <i className="fa fa-calendar"/> </span>

          <h2> My Events </h2>

          <div className="widget-toolbar">
            <DropdownButton id="calendar-showing-dropdown" title="Showing" pullRight bsSize="xsmall">
              <MenuItem onClick={this.changeView.bind(this, 'month')}>Month</MenuItem>
              <MenuItem onClick={this.changeView.bind(this, 'agendaWeek')}>Agenda</MenuItem>
              <MenuItem onClick={this.changeView.bind(this, 'agendaDay')}>Today</MenuItem>
            </DropdownButton>
          </div>
        </header>

        {/* widget div*/}
        <div>
          <div className="widget-body no-padding">
            {/* content goes here */}
            <div className="widget-body-toolbar">

              <div id="calendar-buttons">

                <div className="btn-group">
                  <a onClick={this.prev} className="btn btn-default btn-xs"><i
                    className="fa fa-chevron-left"/></a>
                  <a onClick={this.next} className="btn btn-default btn-xs"><i
                    className="fa fa-chevron-right"/></a>
                </div>
              </div>
            </div>


            <div id="calendar" ref="smartCalendar"/>

            {/* end content */}
          </div>

        </div>
        {/* end widget div */}
      </JarvisWidget>        )
  }
}

export default connect(
  (state)=>(state.events),
  (dispatch)=>(bindActionCreators(EventActions, dispatch))
)(FullCalendarWidget)