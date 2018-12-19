import React from 'react'
import _ from 'lodash'

import 'script-loader!raphael'
import 'morris.js/morris.js'

export default class MorrisGraph extends React.Component {
  componentDidMount() {
    this.renderChart(this.props.data)
  }

  componentWillReceiveProps(nextProps) {
    this.renderChart(nextProps.data)
  }

  renderChart(data) {
    if (data) {
      let options = {
        element: this.refs.morris,
        data: data
      };
      _.each(['xkey', 'ykeys', 'labels', 'pointSize', 'hideHover', 'stacked', 'grid',
        'barColors', 'formater', 'events', 'units', 'xLabels', 'xLabelFormat', 'parseTime'], function (key) {
        if (_.has(this.props, key)) options[key] = this.props[key];
      }.bind(this));

      switch (this.props.type) {
        case 'area':
          Morris.Area(options);
          break;
        case 'bar':
          Morris.Bar(options);
          break;
        case 'line':
          Morris.Line(options);
          break;
        case 'donut':
          Morris.Donut(options);
          break;
      }
    }
  }

  render() {
    return (
      <div className="chart no-padding" ref="morris"/>
    )
  }
}