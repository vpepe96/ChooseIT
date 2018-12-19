import React from 'react'

import FlotChart from '../../../components/graphs/flot/FlotChart'


import request from 'then-request'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'

export default class FlotCharts extends React.Component {

  state = {};

  componentWillMount() {
    request('GET', 'assets/api/graphs/flot.json', {json: true}).done((res)=> {
      this.setState(JSON.parse(res.getBody()));
    })
  }

  tick = () => {
    this.setState({
      updatingData: [FakeDataSource.getRandomData()]
    });
  }

  componentDidMount() {
    this.interval = setInterval(this.tick, 1000);
  }

  componentWillUnmount() {
    clearInterval(this.interval);
  }

  render() {
    return (
      <div id="content">

        <div className="row">
          <BigBreadcrumbs items={['Flot Charts']} icon="fa fa-fw fa-bar-chart-o"  className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats />
        </div>

        <WidgetGrid>
          <div className="row">
            <article className="col-sm-12 col-md-12 col-lg-12">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                  <h2>Bar Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <flot-bar-chart data="barChartData"/>
                    <FlotChart data={this.state.barChartData}
                               options={barChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>

              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                  <h2>Sin Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.sinChartData}
                               options={sinChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-xs-12 col-sm-6 col-md-6 col-lg-6">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Auto Updating Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.updatingData}
                               options={autoUpdatingChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-xs-12 col-sm-6 col-md-6 col-lg-6">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Horizontal Bar Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.horizontalBarChartData}
                               options={horizontalChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-sm-12 col-md-12 col-lg-12">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Sales Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.salesChartData}
                               options={salesChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-xs-12 col-sm-8 col-md-7 col-lg-7">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                  <h2>Plot Percentiles</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.fillChartData}
                               options={fillChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-xs-12 col-sm-4 col-md-5 col-lg-5">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>

                  <h2>Pie Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.pieChartData}
                               options={pieChartDemoOptions}/>
                  </div>
                </div>
              </JarvisWidget>
            </article>

            <article className="col-xs-12">
              <JarvisWidget editbutton={false}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-bar-chart-o"/> </span>
                  <h2>Site Stats Chart</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">
                    <FlotChart data={this.state.siteStatsData}
                               options={siteStatsDemoOptions}/>
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

const colors = {
  "chartBorderColor": "#efefef",
  "chartGridColor": "#DDD",
  "charMain": "#E24913",
  "chartSecond": "#6595b4",
  "chartThird": "#FF9F01",
  "chartFourth": "#7e9d3a",
  "chartFifth": "#BD362F",
  "chartMono": "#000"
};

const barChartDemoOptions = {
  colors: [colors.chartSecond, colors.chartFourth, "#666", "#BBB"],
  grid: {
    show: true,
    hoverable: true,
    clickable: true,
    tickColor: colors.chartBorderColor,
    borderWidth: 0,
    borderColor: colors.chartBorderColor
  },
  legend: true,
  tooltip: true,
  tooltipOpts: {
    content: "<b>%x</b> = <span>%y</span>",
    defaultTheme: false
  }
};

const sinChartDemoOptions = {
  series: {
    lines: {
      show: true
    },
    points: {
      show: true
    }
  },
  grid: {
    hoverable: true,
    clickable: true,
    tickColor: colors.chartBorderColor,
    borderWidth: 0,
    borderColor: colors.chartBorderColor
  },
  tooltip: true,
  tooltipOpts: {
    //content : "Value <b>$x</b> Value <span>$y</span>",
    defaultTheme: false
  },
  colors: [colors.chartSecond, colors.chartFourth],
  yaxis: {
    min: -1.1,
    max: 1.1
  },
  xaxis: {
    min: 0,
    max: 15
  }
};

const horizontalChartDemoOptions = {
  colors: [colors.chartSecond, colors.chartFourth, "#666", "#BBB"],
  grid: {
    show: true,
    hoverable: true,
    clickable: true,
    tickColor: colors.chartBorderColor,
    borderWidth: 0,
    borderColor: colors.chartBorderColor
  },
  legend: true,
  tooltip: true,
  tooltipOpts: {
    content: "<b>%x</b> = <span>%y</span>",
    defaultTheme: false
  }
};

const salesChartDemoOptions = {
  xaxis: {
    mode: "time",
    tickLength: 5
  },
  series: {
    lines: {
      show: true,
      lineWidth: 1,
      fill: true,
      fillColor: {
        colors: [{
          opacity: 0.1
        }, {
          opacity: 0.15
        }]
      }
    },
    //points: { show: true },
    shadowSize: 0
  },
  selection: {
    mode: "x"
  },
  grid: {
    hoverable: true,
    clickable: true,
    tickColor: colors.chartBorderColor,
    borderWidth: 0,
    borderColor: colors.chartBorderColor
  },
  tooltip: true,
  tooltipOpts: {
    content: "Your sales for <b>%x</b> was <span>$%y</span>",
    dateFormat: "%y-%0m-%0d",
    defaultTheme: false
  },
  colors: [colors.chartSecond]

};

const fillChartDemoOptions = {
  xaxis: {
    tickDecimals: 0
  },
  yaxis: {
    tickFormatter: function (v) {
      return v + " cm";
    }
  }
};

const pieChartDemoOptions = {
  series: {
    pie: {
      show: true,
      innerRadius: 0.5,
      radius: 1,
      label: {
        show: false,
        radius: 2 / 3,
        formatter: function (label, series) {
          return '<div style="font-size:11px;text-align:center;padding:4px;color:white;">' + label + '<br/>' + Math.round(series.percent) + '%</div>';
        },
        threshold: 0.1
      }
    }
  },
  legend: {
    show: true,
    noColumns: 1, // number of colums in legend table
    labelFormatter: null, // fn: string -> string
    labelBoxBorderColor: "#000", // border color for the little label boxes
    container: null, // container (as jQuery object) to put legend in, null means default on top of graph
    position: "ne", // position of default legend container within plot
    margin: [5, 10], // distance from grid edge to default legend container within plot
    backgroundColor: "#efefef", // null means auto-detect
    backgroundOpacity: 1 // set to 0 to avoid background
  },
  grid: {
    hoverable: true,
    clickable: true
  }
};

const siteStatsDemoOptions = {
  series: {
    lines: {
      show: true,
      lineWidth: 1,
      fill: true,
      fillColor: {
        colors: [{
          opacity: 0.1
        }, {
          opacity: 0.15
        }]
      }
    },
    points: {
      show: true
    },
    shadowSize: 0
  },
  yaxes: [{
    min: 20,
    tickLength: 5
  }],
  grid: {
    hoverable: true,
    clickable: true,
    tickColor: colors.chartBorderColor,
    borderWidth: 0,
    borderColor: colors.chartBorderColor
  },
  tooltip: true,
  tooltipOpts: {
    content: "%s for <b>%x:00 hrs</b> was %y",
    dateFormat: "%y-%0m-%0d",
    defaultTheme: false
  },
  colors: [colors.charMain, colors.chartSecond],
  xaxis: {
    mode: "time",
    tickLength: 10,
    ticks: 15,
    tickDecimals: 2
  },
  yaxis: {
    ticks: 15,
    tickDecimals: 0
  }
};

const autoUpdatingChartDemoOptions = {
  yaxis: {
    min: 0,
    max: 100
  },
  xaxis: {
    min: 0,
    max: 100
  },
  colors: [colors.chartFourth],
  series: {
    lines: {
      lineWidth: 1,
      fill: true,
      fillColor: {
        colors: [{
          opacity: 0.4
        }, {
          opacity: 0
        }]
      },
      steps: false
    }
  }
};


const FakeDataSource = {
  data: [],
  total: 200,
  getRandomData: function () {
    if (this.data.length > 0)
      this.data = this.data.slice(1);

    // do a random walk
    while (this.data.length < this.total) {
      var prev = this.data.length > 0 ? this.data[this.data.length - 1] : 50;
      var y = prev + Math.random() * 10 - 5;
      if (y < 0)
        y = 0;
      if (y > 100)
        y = 100;
      this.data.push(y);
    }

    // zip the generated y values with the x values
    var res = [];
    for (var i = 0; i < this.data.length; ++i)
      res.push([i, this.data[i]])
    return res;
  }
};

