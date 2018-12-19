/**
 * Created by griga on 12/1/15.
 */

import React from 'react'
import classnames from 'classnames'

import {findDOMNode} from 'react-dom'


export default class JarvisWidget extends React.Component {
  static counter = 0;

  static defaultProps = {
    colorbutton: true,
    editbutton: true,
    togglebutton: true,
    deletebutton: true,
    fullscreenbutton: true,
    custombutton: false,
    collapsed: false,
    sortable: true,
    hidden: false,
    color: false,
    load: false,
    refresh: false
  };

  constructor(props){
    super(props);

  }

  componentWillMount(){

  }

  genId() {
    if (this.props.name) {
      return this.props.name
    } else {

      let id = 'jarviswidget-' + JarvisWidget.counter++;
      id = id.toLowerCase().replace(/\W+/gm, '-');

      let url = location.pathname.substr(1).replace(/\//g, '-');
      id = url + '--' + id;

      return id
    }
  }

  render() {
    const colorClass = this.props.color ? 'jarviswidget-color-' + this.props.color : ''
    const classes = classnames('jarviswidget', colorClass, {
      'jarviswidget-sortable': this.props.sortable == true
    });

    const widgetProps = {};

    this.widgetId = this.genId();

    ['colorbutton', 'editbutton', 'togglebutton', 'deletebutton',
      'fullscreenbutton', 'custombutton', 'sortable'].forEach((option) =>{
      if (!this.props[option])
        widgetProps['data-widget-' + option] = false
    });

    ['hidden', 'collapsed'].forEach((option) => {
      if (this.props[option])
        widgetProps['data-widget-' + option] = true
    });

    ['refresh', 'load'].forEach((option) =>{
      if (this.props[option])
        widgetProps['data-widget-' + option] = this.props[option]
    });

    return (
      <div className={classes} id={this.widgetId} ref="widget"
           {...widgetProps}
      >{this.props.children}</div>
    )
  }


  componentDidMount() {
    $(this.refs[this.widgetId]).find('.widget-body').prepend('');
  }
}

class Body extends React.Component{
  render(){
    const {children, props} = {...this.props};
    return (
      <div {...props}>
        {
          this.props.editbutton ? (<div className="jarviswidget-editbox"><input className="form-control" type="text" /></div>) : null
        }
        <div className="widget-body">
          {children}
        </div>
      </div>
    )
  }
}


JarvisWidget.Body = Body