
import React from 'react'

import 'imports-loader?this=>window!smartadmin-plugins/flot-bundle/flot-bundle.min.js'

export default class FlotChart extends React.Component {
  componentDidMount() {
    this._renderChart(this.props.data)
  }

  componentWillReceiveProps(nextProps) {
    if (JSON.stringify(nextProps.data) !== JSON.stringify(this.props.data)) {
      this._renderChart(nextProps.data)
    }
  }

  _renderChart(data) {
    if (data)
      $.plot(this.container, data, this.props.options)
  }

  shouldComponentUpdate(nextProps, nextState) {
    return JSON.stringify(nextProps.data) !== JSON.stringify(this.props.data)
  }

  render() {
    let className = this.props.className || 'chart';
    return (
      <div ref={container => this.container = container} className={className}/>
    )
  }
}