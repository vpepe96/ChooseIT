import React from 'react'

import 'bootstrap-progressbar/bootstrap-progressbar.min.js'


export default class UiProgressbar extends React.Component{
  componentDidMount () {
    $(this.refs.progressbar).progressbar({
      display_text: 'fill'
    })
  }

  render () {
    return <div {...this.props} ref="progressbar"/>
  }
}