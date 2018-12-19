/**
 * Created by griga on 12/1/15.
 */

import 'smartadmin-plugins/smartwidgets/jarvis.widget.ng2.js'

import React from 'react'

import defaults from './WidgetDefaults' ;

export default class WidgetGrid extends React.Component{

    render(){
        return (
            <section id="widget-grid" ref={(grid) => this.grid = grid}>
                {this.props.children}
            </section>
        )
    }
    componentDidMount(){
        $(this.grid).jarvisWidgets(defaults);
    }
}