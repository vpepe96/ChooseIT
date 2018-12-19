import React from 'react'

import 'script-loader!to-markdown/dist/to-markdown.js'
import 'script-loader!markdown/lib/markdown.js'
import 'script-loader!he/he.js'
import 'script-loader!bootstrap-markdown/js/bootstrap-markdown.js'

export default class MarkdownEditor extends React.Component {
  componentDidMount() {
    $(this.refs.editor).markdown()
  }

  render() {
    return (
      <textarea ref="editor" defaultValue={this.props.value} className={this.props.className}/>
    )
  }
}