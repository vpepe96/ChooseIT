import React from 'react'
import Moment from '../../../components/utils/Moment'
import HtmlRender from '../../../components/utils/HtmlRender'


export default class ChatBody extends React.Component{
    componentDidUpdate(){
        const $ref = $(this.refs.body);
        $ref.animate({scrollTop: $ref[0].scrollHeight});
    }
    render () {
        let messages = this.props.messages || [];

        return (
            <div id="chat-body" className="chat-body custom-scroll" ref="body">
                <ul>
                    {messages.map((message, idx)=>{
                        return(<li className="message" key={'chat-message-'+idx}>
                            <img className="message-picture online" src={message.user.picture}/>

                            <div className="message-text">
                                <time>
                                    <Moment date={message.date} />
                                </time>

                                <a onClick={this.props.onMessageTo.bind(this, message.user)}
                                   className="username">{message.user.username}</a>

                                <HtmlRender html={message.body}/>
                            </div>
                        </li>)
                        })}
                </ul>
            </div>
        )
    }
}