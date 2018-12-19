import React from 'react'

import 'script-loader!select2/dist/js/select2.min.js'

export default class Select2 extends React.Component {

  componentDidMount() {
    $(this.refs.select).select2()
  }

  componentWillUnmount() {
    $(this.refs.select).select2('destroy');
  }

  render() {
    let {children, ...props} = this.props;
    return (
      <select {...props} ref="select">
        {children}
      </select>
    )
  }

}