import React from 'react'
import {bindActionCreators} from 'redux'

import {connect} from 'react-redux';

import * as LayoutActions from '../layout/LayoutActions'


class ResetWidgets extends React.Component{
    render () {
        return (
            <span id="refresh" className="btn btn-ribbon" onClick={this.props.factoryReset}>
                <i className="fa fa-refresh" />
            </span>
        )
    }
}


const mapStateToProps = (state, ownProps) => (state.layout);

function mapDispatchToProps(dispatch) {
  return bindActionCreators(LayoutActions, dispatch)
}

export default connect(mapStateToProps, mapDispatchToProps)(ResetWidgets)