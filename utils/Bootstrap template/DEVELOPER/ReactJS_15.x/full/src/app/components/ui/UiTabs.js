import React from 'react'
import ReactDOM from 'react-dom'

export default class UiTabs extends React.Component{
    componentDidMount(){
        $(ReactDOM.findDOMNode(this)).tabs();
    }
    render() {
        let {children, ...props} = this.props;
        return (
            <div {...props}>
                {children}
            </div>
        )
    }
}