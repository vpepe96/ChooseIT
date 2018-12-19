import React from 'react'

export default class HtmlRender extends React.Component {
  rawMarkup() {
    return {__html: this.props.html}
  }

  render() {
    let {html, ...props} = this.props;
    return ( this.props.html ?
      <div {...props} dangerouslySetInnerHTML={this.rawMarkup()}></div>
      : null)
  }
}
