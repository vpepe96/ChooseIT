import React from 'react'

import request from 'then-request'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

import ChartJsGraph from '../../../components/graphs/chartjs/ChartJsGraph'


export default class ChartJs extends React.Component {

  state = {};

  componentWillMount() {
    request('GET', 'assets/api/graphs/chartjs.json', {json: true}).done((res)=> {
      this.setState(JSON.parse(res.getBody()));
    })
  }

  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['ChartJs']} icon="fa fa-fw fa-bar-chart-o" className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>

        <WidgetGrid>
          <div className="row">
            <article className="col-xs-12 col-sm-6 col-md-6 col-lg-6">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Line Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="line" data={this.state['line-chart']}/>
                  </div>
                </div>
              </JarvisWidget>

              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Radar Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="radar" data={this.state['radar-chart']}/>
                  </div>
                </div>
              </JarvisWidget>

              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Polar Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="polarArea" data={this.state['polar-chart']}/>
                  </div>
                </div>
              </JarvisWidget>

            </article>

            <article className="col-xs-12 col-sm-6 col-md-6 col-lg-6">

              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Bar Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="bar" data={this.state['bar-chart']}/>
                  </div>
                </div>
              </JarvisWidget>


              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Doughnut Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="doughnut" data={this.state['doughnut-chart']}/>
                  </div>
                </div>
              </JarvisWidget>


              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Pie Chart</h2>
                </header>
                <div>
                  <div className="widget-body">
                    <ChartJsGraph type="pie" data={this.state['pie-chart']}/>
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