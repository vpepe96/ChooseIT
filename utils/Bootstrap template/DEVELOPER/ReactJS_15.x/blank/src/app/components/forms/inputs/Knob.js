import React from 'react'
import 'jquery-knob'

export default class Timepicker extends React.Component {
  componentDidMount() {
    $(this.refs.input).knob(this.props.options)
  }

  render() {
    const {options, ...props} = {...this.props}
    return (
      <input type="text" ref="input" {...props}/>
    )
  }
}