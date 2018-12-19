import React from 'react'
import Reflux from 'reflux'

import LanguageStore from './LanguageStore'


export default class Msg extends React.Component {

  constructor(props) {
    super(props)
    this.state = {}
    this.store = LanguageStore
  }


  render() {
    let phrase = LanguageStore.translate(this.props.phrase)
    return (
      <span>{phrase}</span>
    )
  }
}