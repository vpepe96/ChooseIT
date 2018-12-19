import React from 'react'
import ReactDOM from 'react-dom'

export default class UiMenu extends React.Component{
    componentDidMount(){
        $(ReactDOM.findDOMNode(this)).menu();
    }
    render() {
        return this.props.children
    }
}