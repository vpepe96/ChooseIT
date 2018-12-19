import React from 'react'

import Chart from 'chart.js'

import pressets from './ChartJsPressets'

export default class ChartJsGraph extends React.Component {
  componentDidMount = ()=> {
    this.renderChart(this.props.data)
  }
  componentWillReceiveProps = (nextProps) => {
    this.renderChart(nextProps.data)
  }

  renderChart(data) {
    var ctx = this.refs.canvas.getContext("2d");
    if (data) {
      let chart = new Chart(ctx, {type: this.props.type, data: data, options: pressets[this.props.type] || {}});
      chart.update();
    }
  }

  render() {
    return (
      <canvas className={this.props.className} ref="canvas"/>
    )
  }
}