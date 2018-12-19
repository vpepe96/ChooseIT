import React from 'react'
import Dygraph from 'dygraphs'


export default class DygraphsChart extends React.Component{
  componentDidMount () {
    this.renderChart(this.props.data)
  }
  componentWillReceiveProps (nextProps) {
    this.renderChart(nextProps.data)
  }
  renderChart (data) {
    if (data) {
      new Dygraph(this.refs.dygraph, data, this.props.options || {})
    }
  }

  render () {
    return (
      <div style={this.props.style} ref="dygraph"/>
    )
  }
}