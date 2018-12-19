/**
 * Created by griga on 11/30/15.
 */

import React from 'react'

import WidgetGrid from '../../../components/widgets/WidgetGrid'
import Stats from '../../../components/common/Stats'
import BigBreadcrumbs from '../../../components/navigation/components/BigBreadcrumbs'

import BirdEyeWidget from '../components/BirdEyeWidget'
import LiveFeeds from '../components/LiveFeeds'
import ChatWidget from '../../../components/chat/components/ChatWidget'
import FullCalendarWidget from '../../../components/calendar/components/FullCalendarWidget'
import TodoWidget from '../../../components/todo/components/TodoWidget'


export default class Dashboard extends React.Component {
  render() {
    return (
      <div id="content">

        <div className="row">
          <BigBreadcrumbs items={['Dashboard', 'My Dashboard']}
                          className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>

        <WidgetGrid>

          <div className="row">
            <article className="col-sm-12">

              <LiveFeeds />

            </article>
          </div>


          <div className="row">

            <article className="col-sm-12 col-md-12 col-lg-6">

              <ChatWidget />

              <FullCalendarWidget />

            </article>

            <article className="col-sm-12 col-md-12 col-lg-6">

              <BirdEyeWidget />

              <TodoWidget />

            </article>
          </div>
        </WidgetGrid>
      </div>
    )
  }
}