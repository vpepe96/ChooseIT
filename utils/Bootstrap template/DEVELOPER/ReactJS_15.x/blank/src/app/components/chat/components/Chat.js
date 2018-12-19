import React from 'react'
import {bindActionCreators} from 'redux'
import {connect} from 'react-redux'

import * as ChatActions from '../ChatActions'

import ChatUsers from './ChatUsers'
import ChatBody from './ChatBody'
import ChatForm from './ChatForm'

class Chat extends React.Component {
  render() {

    return (
      <div className={this.props.className}>

        <ChatUsers users={this.props.chat.users}/>

        <ChatBody
          onMessageTo={this.props.messageTo}
          messages={this.props.chat.messages}/>

        <ChatForm
          message={this.props.chat.message}
          onMessageUpdate={this.props.messageUpdate}
          onMessageSend={this.props.messageSend}
          user={this.props.user}
        />
      </div>
    )
  }
}

export default connect(
  (state)=> {
    const {chat, user} = {...state};
    return {
      chat, user
    }
  },
  (dispatch) => {
    return bindActionCreators(ChatActions, dispatch)
  }
)(Chat)