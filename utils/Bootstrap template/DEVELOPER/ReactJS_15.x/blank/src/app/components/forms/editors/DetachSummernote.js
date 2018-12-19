import React from 'react'

export default class DetachSummernote extends React.Component{
  onClick = ()=>{
    $(this.props.target).summernote('destroy');
  };

  render() {
    let {children, ...props} = this.props;
    return (
      <button {...props} onClick={this.onClick}>
        {children}
      </button>
    )
  }
}