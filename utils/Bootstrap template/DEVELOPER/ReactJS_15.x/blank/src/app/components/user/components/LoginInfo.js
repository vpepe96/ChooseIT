import React from 'react'
import ToggleShortcut from './ToggleShortcut'


import {connect} from 'react-redux';

class LoginInfo extends React.Component {

  componentWillMount() {

  }

  render() {
    return (

      <div className="login-info">
			    <span>
			        <ToggleShortcut>
			            <img src={this.props.picture} alt="me"
                       className="online"/><span>{ this.props.username }</span><i className="fa fa-angle-down"/>
			        </ToggleShortcut>
			     </span>
      </div>
    )
  }
}

const mapStateToProps = (state)=>(state.user)

export default connect(mapStateToProps)(LoginInfo)