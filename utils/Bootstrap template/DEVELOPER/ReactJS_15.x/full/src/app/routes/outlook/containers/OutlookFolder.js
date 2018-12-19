import React from 'react'
import _ from 'lodash'
import {Link} from 'react-router'
import {OverlayTrigger, Tooltip} from 'react-bootstrap'
import classnames from 'classnames'

import Moment from '../../../components/utils/Moment'

import {connect} from 'react-redux'
import {bindActionCreators} from 'redux'
import {outlookFetchFolder} from '../OutlookActions'


class OutlookFolder extends React.Component {

  currentFolder = null;

  componentWillReceiveProps(nextProps){
    if(this.currentFolder != nextProps.params.folder){
      this.props.dispatch(outlookFetchFolder(nextProps.params.folder))
      this.currentFolder = nextProps.params.folder
    }
  }


  getTeaser(message) {
    const clearBody = message.body.replace(/<[^<>]+?>/gm, ' ').replace(/(\s{2}|\n)/gm, ' ');

    const teaserMaxLength = 55 - message.subject.length;

    return clearBody.length > teaserMaxLength ? clearBody.substring(0, teaserMaxLength) + '...' : clearBody;
  }

  getAttachmentsTooltip(message) {
    if (message.attachments && message.attachments.length) {
      const tooltipId = 'message-' + message._id + "-attachments-tooltip";
      const tooltipLabel = 'FILES: ' + _.map(message.attachments, 'name').join(', ');
      return (
        <OverlayTrigger placement="left" overlay={<Tooltip id={tooltipId}>{tooltipLabel}</Tooltip>}>
          <span className="txt-color-darken"><i className="fa fa-paperclip fa-lg"/></span>
        </OverlayTrigger>
      );
    } else {
      return ''
    }
  }


  getMessageLabels(message) {
    let labels = {
      "home": {
        "name": "HOME",
        "color": "teal"
      },
      "work": {
        "name": "WORK",
        "color": "orange"
      }
    };

    return _.map(message.labels, (label, idx) => {
      return <span key={message._id + idx}
                   className={'label bg-color-' + labels[label].color }>{labels[label].name}</span>;
    })
  }

  render() {
    return (
      <div className="table-wrap custom-scroll">
        <table id="inbox-table" className="table table-striped table-hover">
          <tbody>
          {this.props.messages.map((message) => {
              let classNames = classnames({
                unread: !message.read
              });
              return ( message.folder == this.props.params.folder ?
                <tr key={message._id} id="msg1" className={classNames}>
                  <td className="inbox-table-icon">
                    <div className="checkbox">
                      <label>
                        <input type="checkbox"
                               className="checkbox style-2"/>
                        <span/>
                      </label>
                    </div>
                  </td>
                  <td className="inbox-data-from hidden-xs hidden-sm">
                    <Link to={'outlook/detail/' + message._id}>
                      <div>
                        {message.contact.name}
                      </div>
                    </Link>
                  </td>
                  <td className="inbox-data-message">
                    <Link to={'outlook/detail/' + message._id}>
                      <div>
                                                <span>
                                                    {this.getMessageLabels(message)}
                                                  {message.subject}
                                                </span>
                        { this.getTeaser(message) }
                      </div>
                    </Link>
                  </td>
                  <td className="inbox-data-attachment hidden-xs">
                    <Link to={'outlook/detail/' + message._id}>
                      { this.getAttachmentsTooltip(message) }
                    </Link>
                  </td>
                  <td className="inbox-data-date hidden-xs">
                    <Moment date={message.date} format="h:mm a"/>
                  </td>
                </tr>

                : null)
            }
          )}

          </tbody>
        </table>

      </div>
    )
  }
}


export default connect((state)=>(state.outlook))(OutlookFolder)