import React from 'react'

import 'script-loader!bootstrap-slider/dist/bootstrap-slider.min.js'

export default class UiSlider extends React.Component {
  componentDidMount() {
    $(this.refs.slider).bootstrapSlider();
  }

  render() {
    return <input type="text" ref="slider" {...this.props} />
  }
}