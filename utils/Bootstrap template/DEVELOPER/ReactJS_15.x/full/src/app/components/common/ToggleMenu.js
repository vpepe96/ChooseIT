import React from 'react'

export default class ToggleMenu  extends React.Component{
  toggleMenu(e) {
    const $body = $('body');
    const $html = $('html');

    if (!$body.hasClass("menu-on-top")){
      $html.toggleClass("hidden-menu-mobile-lock");
      $body.toggleClass("hidden-menu");
      $body.removeClass("minified");
    } else if ( $body.hasClass("menu-on-top") && $body.hasClass("mobile-view-activated") ) {
      $html.toggleClass("hidden-menu-mobile-lock");
      $body.toggleClass("hidden-menu");
      $body.removeClass("minified");
    }
    e.preventDefault();
  }
  render() {
    return (
      <div id="hide-menu" className={this.props.className}>
                <span>
                    <a onClick={this.toggleMenu} title="Collapse Menu"><i className="fa fa-reorder"/></a>
                </span>
      </div>

    )
  }
}