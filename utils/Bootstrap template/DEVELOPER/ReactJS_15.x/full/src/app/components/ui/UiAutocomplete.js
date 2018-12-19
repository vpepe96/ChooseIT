import React from 'react'

export default class  UiAutocomplete extends React.Component{
    componentDidMount(){
        $(this.refs.input).autocomplete({
            source: this.props.source
        });
    }
    render () {

      const { source, ...props} = {...this.props};

      return <input type="text" {...props} ref="input"/>
    }
}