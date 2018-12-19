import React from 'react'
import {findDOMNode} from 'react-dom'
import Dropzone from 'dropzone'
Dropzone.autoDiscover = false;

export default class DropzoneInput extends React.Component {

  componentDidMount() {
    let element = $(findDOMNode(this));
    let options = this.props.options || {};
    element.dropzone(options)
  }

  render() {
    return (
      this.props.children
    )
  }
}