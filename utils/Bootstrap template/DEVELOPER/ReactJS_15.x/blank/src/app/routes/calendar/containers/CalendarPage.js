import React from 'react'

import {OverlayTrigger, Tooltip, Popover} from 'react-bootstrap'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

import AddExternalEvent from '../../../components/calendar/components/AddExternalEvent'
import ExternalEvents from '../../../components/calendar/components/ExternalEvents'
import FullCalendarWidget from '../../../components/calendar/components/FullCalendarWidget'

export default class CalendarPage extends React.Component {
  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['Home', 'Calendar']} icon="fa fa-fw fa-calendar" className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>
        {/* widget grid */}
        <WidgetGrid>
          {/* row */}
          <div className="row">

            <div className="col-sm-12 col-md-12 col-lg-3">

              <JarvisWidget color="blueDark">
                <header>
                  <h2> Add Events </h2>
                </header>

                <JarvisWidget.Body>
                  <AddExternalEvent />
                </JarvisWidget.Body>
              </JarvisWidget>

              <div className="well well-sm" id="event-container">
                <ExternalEvents />
              </div>
            </div>


            <article className="col-sm-12 col-md-12 col-lg-9">
              <FullCalendarWidget />
            </article>
          </div>
        </WidgetGrid>
      </div>
    )
  }
}