import React from 'react'

import ReactDOM from 'react-dom'

import 'script-loader!smartadmin-plugins/bower_components/jquery.easy-pie-chart/dist/jquery.easypiechart.min.js';

export default class EasyPieChartContainer extends React.Component{
    componentDidMount(){
        $('.easy-pie-chart', $(ReactDOM.findDOMNode(this))).each(function(idx, element) {

            const $this = $(element),
                barColor = $this.css('color') || $this.data('pie-color'),
                trackColor = $this.data('pie-track-color') || 'rgba(0,0,0,0.04)',
                size = parseInt($this.data('pie-size')) || 25;

            $this.easyPieChart({

                barColor : barColor,
                trackColor : trackColor,
                scaleColor : false,
                lineCap : 'butt',
                lineWidth : parseInt(size / 8.5),
                animate : 1500,
                rotate : -90,
                size : size,
                onStep: function(from, to, percent) {
                    $(this.el).find('.percent').text(Math.round(percent));
                }

            });
        });
    }
    render () {
        return (
            <div className={this.props.className}>
                {this.props.children}
            </div>
        )
    }
}