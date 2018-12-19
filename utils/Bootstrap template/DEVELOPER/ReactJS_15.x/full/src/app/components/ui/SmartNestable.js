import React from 'react'

import {findDOMNode} from 'react-dom'

import 'script-loader!smartadmin-plugins/bower_components/jquery-nestable/jquery.nestable.js'


export default class SmartNestable extends React.Component {

  componentDidMount() {

    let element = $(findDOMNode(this))
    let options = {};
    if (this.props.group) {
      options.group = this.props.group;
    }
    element.nestable(options);

    if (this.props.onChange) {
      element.on('change', function () {
        this.props.onChange(element.nestable('serialize'))
      }.bind(this));
      this.props.onChange(element.nestable('serialize'))
    }

  }


  render() {
    return (
      this.props.children
    )
  }
}