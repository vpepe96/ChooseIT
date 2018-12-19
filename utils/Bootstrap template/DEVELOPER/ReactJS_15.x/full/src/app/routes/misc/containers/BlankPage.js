import React from 'react'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget} from '../../../components'

export default class BlankPage extends React.Component {
  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['Page Header', 'Subtitle']} icon="home"
                          className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>

        </div>

        <WidgetGrid>

          <div className="row">

            <article className="col-sm-12 col-md-12 col-lg-12">

              <JarvisWidget >

                <header>
                  <h2> Widget Title</h2>

                </header>

                <div>
                  <div className="widget-body">


                  </div>
                </div>

              </JarvisWidget>

            </article>

          </div>

        </WidgetGrid>

      </div>
    )
  }
}