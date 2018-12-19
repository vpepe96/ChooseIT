import React from 'react'
import {Popover, OverlayTrigger} from 'react-bootstrap'

import {bindActionCreators} from 'redux'
import * as VoiceActions from '../VoiceActions'
import {connect} from 'react-redux';

import SpeechHelp from './SpeechHelp'

class SpeechButton extends React.Component {

  hidePopover = ()=> {
    this.refs.vpOverlay.hide()
  };


  render() {


    const popover = (
      <Popover
        ref="popover"
        id="popover-basic"
        placement="bottom"
        title={null}
      >{
        !this.props.hasError
          ?
          <h4 className="vc-title">Voice command activated <br />
            <small>Please speak clearly into the mic</small>
          </h4>
          :
          <h4 className="vc-title-error text-center">
            <i className="fa fa-microphone-slash"/> Voice command failed
            <br />
            <small className="txt-color-red">Must <strong>"Allow"</strong> Microphone</small>
            <br />
            <small className="txt-color-red">Must have <strong>Internet Connection</strong>
            </small>
          </h4>
      }

        <div>
          <a className="btn btn-success" id="speech-help-btn"
             onClick={this.props.voiceControlShowHelp}>See Commands</a>
          <a className="btn bg-color-purple txt-color-white"
             onClick={this.hidePopover}>Close Popup</a>
        </div>
      </Popover>
    )

    return (
      <div id="speech-btn" className={this.props.className}>
        <div>
          <OverlayTrigger trigger={this.props.started ? null : "click" } placement="bottom" ref="vpOverlay" overlay={popover}>
            <a onClick={this.voiceControlToggle} title="Voice Command" id="voice-command-btn"><i
              className="fa fa-microphone"/></a>
          </OverlayTrigger>

        </div>
        <SpeechHelp showHelp={this.props.showHelp} onHide={this.props.voiceControlHideHelp}/>
      </div>
    )
  }

  voiceControlToggle = (e)=> {
    if (this.props.started) {
      this.hidePopover();
      this.props.voiceControlOff()
    } else {
      this.props.voiceControlOn()
    }
  }
}

export default connect(
  (state)=> {
    return state.voice
  },
  (dispatch)=> {
    return bindActionCreators(VoiceActions, dispatch)
  }
)(SpeechButton)