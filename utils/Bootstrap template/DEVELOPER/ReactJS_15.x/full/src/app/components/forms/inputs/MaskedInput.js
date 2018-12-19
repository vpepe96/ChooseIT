import React from 'react'

import 'script-loader!jquery.maskedinput/src/jquery.maskedinput.js'


export default class MaskedInput extends React.Component {

  componentDidMount() {

    var options = {};
    if (this.props.maskPlaceholder) options.placeholder = this.props.maskPlaceholder;
    $(this.refs.input).mask(this.props.mask, options);

  }

  render() {

    const {maskPlaceholder, mask, ...props} = {...this.props}
    return (
      <input ref="input" {...props}/>
    )
  }
}