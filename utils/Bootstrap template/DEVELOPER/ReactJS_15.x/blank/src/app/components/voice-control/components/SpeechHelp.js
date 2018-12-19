/**
 * Created by griga on 11/21/16.
 */

import React from 'react'

import {Modal} from 'react-bootstrap'

export default class SpeechHelp extends React.Component {

  render() {
    return (

        <Modal show={this.props.showHelp}>
          <Modal.Body>


            <h1><i className="fa fa-microphone text-muted"/>&nbsp;&nbsp; SmartAdmin Voice Command</h1>
            <hr className="simple"/>
            <h5>Instruction</h5>

            Click <span className="text-success">"Allow"</span> to access your microphone and activate Voice Command.
            You will notice a <span className="text-primary"><strong>BLUE</strong> Flash</span> on the microphone icon
            indicating activation.
            The icon will appear <span className="text-danger"><strong>RED</strong></span> <span
            className="label label-danger"><i
            className="fa fa-microphone fa-lg"/></span> if you <span className="text-danger">"Deny"</span> access or
            don't have
            any microphone installed.
            <br />
            <br />
            As a security precaution, your browser will disconnect the microphone every 60 to 120 seconds (sooner
            if not
            being used). In which case Voice Command will prompt you again to <span
            className="text-success">"Allow"</span>
            or
            <span className="text-danger">"Deny"</span> access to your microphone.
            <br />
            <br />
            If you host your page over <strong>http<span className="text-success">s</span></strong> (secure
            socket layer)
            protocol you can wave this security measure and have an unintrupted Voice Command.
            <br />
            <br />
            <h5>Commands</h5>
            <ul>
              <li>
                <strong>'show' </strong> then say the <strong>*page*</strong> you want to go to. For
                example <strong>"show
                inbox"</strong> or <strong>"show calendar"</strong>
              </li>
              <li>
                <strong>'mute' </strong> - mutes all sound effects for the theme.
              </li>
              <li>
                <strong>'sound on'</strong> - unmutes all sound effects for the theme.
              </li>
              <li>
                <span className="text-danger"><strong>'stop'</strong></span> - deactivates voice command.
              </li>
              <li>
                <span className="text-primary"><strong>'help'</strong></span> - brings up the command list
              </li>
              <li>
                <span className="text-danger"><strong>'got it'</strong></span> - closes help modal
              </li>
              <li>
                <strong>'hide navigation'</strong> - toggle navigation collapse
              </li>
              <li>
                <strong>'show navigation'</strong> - toggle navigation to open (can be used again to
                close)
              </li>
              <li>
                <strong>'scroll up'</strong> - scrolls to the top of the page
              </li>
              <li>
                <strong>'scroll down'</strong> - scrollts to the bottom of the page
              </li>
              <li>
                <strong>'go back' </strong> - goes back in history (history -1 click)
              </li>
              <li>
                <strong>'logout'</strong> - logs you out
              </li>
            </ul>
            <br />
            <h5>Adding your own commands</h5>
            Voice Command supports up to 80 languages. Adding your own commands is extreamly easy. All
            commands are stored
            inside <strong>smartadmin.config.js</strong> file under the <code>config.commands
            = {'{...}'}</code>.

            <hr className="simple"/>
            <div className="text-right">
              <button type="button" className="btn btn-success btn-lg" onClick={this.props.onHide}
              > Got it!
              </button>
            </div>


          </Modal.Body>
        </Modal>

    );
  }
}

