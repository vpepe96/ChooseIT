import React from 'react'

import 'script-loader!clockpicker/dist/bootstrap-clockpicker.min.js'

export default class Clockpicker extends React.Component {
  componentDidMount() {
    const element = $(this.refs.input);
    const options = {
      placement: 'top',
      donetext: 'Done'
    };
    element.clockpicker(options);
  }
  render() {
    return (
      <input type="text" {...this.props} ref="input"/>
    )
  }
}