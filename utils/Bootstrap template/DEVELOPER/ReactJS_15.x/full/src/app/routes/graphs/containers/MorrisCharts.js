import React from 'react'

import request from 'then-request'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

import MorrisGraph from '../../../components/graphs/morris/MorrisGraph'


export default class MorrisCharts extends React.Component{

  state = {};

  componentWillMount() {
    request('GET', 'assets/api/graphs/morris.json', {json: true}).done((res)=> {
      this.setState(JSON.parse(res.getBody()));
    })
  }

  render () {
        return (
            <div id="content">
                <div className="row">
                    <BigBreadcrumbs items={['Morris Charts']} icon="fa fa-fw fa-bar-chart-o" className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
                    <Stats />
                </div>
                <WidgetGrid>
                    <div className="row">

                        <article className="col-sm-12 col-md-12 col-lg-12">
                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                                    <h2>Sales Graphs</h2>
                                </header>
                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state.sales}
                                                     type="area"
                                                     xkey="period"
                                                     ykeys={['iphone', 'ipad', 'itouch']}
                                                     labels={ ['iPhone', 'iPad', 'iPod Touch']}
                                                     pointSize={2}
                                                     hideHover="auto"/>
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Area Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['area-demo']}
                                                     type="area"
                                                     xkey="x"
                                                     ykeys={['y', 'z']}
                                                     labels={['Y', 'Z']}/>
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Bar Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['bar-demo']}
                                                     type="bar"
                                                     xkey="x"
                                                     ykeys={'y'}
                                                     labels={'Y'}
                                                     barColors={this._barColorsDemo}/>
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Normal Bar Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['normal-bar-demo']}
                                                     type="bar"
                                                     xkey={'x'}
                                                     ykeys={['y', 'z', 'a']}
                                                     labels={['Y', 'Z', 'A']}/>
                                        <morris-normal-bar-graph/>
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Stacked Bar Graph</h2>
                                </header>
                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['stacked-bar-demo']}
                                                     type="bar"
                                                     xkey={ 'x'}
                                                     ykeys={ ['y', 'z', 'a']}
                                                     labels={ ['Y', 'Z', 'A']}
                                                     stacked={ true}/>
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Year Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['line-year-demo']}
                                                     type="line"
                                                     xkey={'period'}
                                                     ykeys={['licensed', 'sorned']}
                                                     labels={['Licensed', 'SORN']}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Donut Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['donut-demo']}
                                                     type="donut"
                                                     formater={this._formaterDemo}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Time Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['line-time-demo']}
                                                     type="line"
                                                     xkey={'period'}
                                                     ykeys={['licensed', 'sorned']}
                                                     labels={['Licensed', 'SORN']}
                                                     events={['2011-04', '2011-08']}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Line Graph A</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['line-graph-a-demo']}
                                                     type="line"
                                                     xkey={'period'}
                                                     ykeys={['a']}
                                                     labels={['Series A']}
                                                     units={'%'}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Line Graph B</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['line-graph-b-demo']}
                                                     type="line"
                                                     xkey={'period'}
                                                     ykeys={['licensed', 'sorned', 'other']}
                                                     labels={['Licensed', 'SORN', 'Other']}
                                                     xLabels={'day'}
                                                     xLabelFormat={function(d) {
                                                        return (d.getMonth() + 1) + '/' + d.getDate() + '/' + d.getFullYear();
                                                     }}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-6">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>No Grid Graph</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['no-grid-demo']}
                                                     type="line"
                                                     xkey={'period'}
                                                     ykeys={['licensed', 'sorned']}
                                                     labels={['Licensed', 'SORN']}
                                                     grid={false}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>

                        <article className="col-xs-12 col-sm-12">

                            <JarvisWidget editbutton={false}>
                                <header>
                                    <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                                    <h2>Line Graph C</h2>
                                </header>

                                <div>
                                    <div className="widget-body no-padding">
                                        <MorrisGraph data={this.state['line-graph-c-demo']}
                                                     type="line"
                                                     xkey={'elapsed'}
                                                     ykeys={['value']}
                                                     labels={['value']}
                                                     parseTime={false}
                                        />
                                    </div>
                                </div>
                            </JarvisWidget>

                        </article>


                    </div>
                </WidgetGrid>
            </div>
        )
    }
    _barColorsDemo (row, series, type) {
        if (type === 'bar') {
            var red = Math.ceil(150 * row.y / 8);
            return 'rgb(' + red + ',0,0)';
        } else {
            return '#000';
        }
    }
    _formaterDemo (x) {
        return x + "%"
    }
}