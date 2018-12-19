import React from 'react'
import 'bootstrap-colorpicker/dist/js/bootstrap-colorpicker.js'

import './Colorpicker.css'

export default class Colorpicker extends React.Component {
  componentDidMount() {
      $(this.refs.input).colorpicker({});
  }

  render() {
    return (
      <input type="text" ref="input" {...this.props}/>
    )
  }
}