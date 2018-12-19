/**
 * Created by griga on 11/30/15.
 */

import React from 'react'

let $body = $('body');

export default class MinifyMenu extends React.Component{
    toggle() {
        if (!$body.hasClass("menu-on-top")) {
            $body.toggleClass("minified");
            $body.removeClass("hidden-menu");
            $('html').removeClass("hidden-menu-mobile-lock");
        }
    }
    render() {
        return (
            <span className="minifyme" data-action="minifyMenu" onClick={this.toggle}>
               <i className="fa fa-arrow-circle-left hit"/>
           </span>
        )
    }
}