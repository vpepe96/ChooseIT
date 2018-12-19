import React from 'react'
import {findDOMNode} from 'react-dom'

import 'script-loader!smartadmin-plugins/bower_components/bootstrapvalidator/dist/js/bootstrapValidator.min.js'


export default class BootstrapValidator extends React.Component {

  componentDidMount() {
    $(findDOMNode(this)).bootstrapValidator(this.props.options || {})
  }

  render() {
    return (
      this.props.children
    )
  }
}