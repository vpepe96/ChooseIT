import React from 'react'
import classnames from 'classnames'

import {ButtonGroup, Button} from 'react-bootstrap'

import {connect} from 'react-redux'

import {addExternal} from '../EventActions'

class AddExternalEvent extends React.Component {
  state = {
    title: "",
    description: "",
    icon: 'fa-info',
    selectedClassName: {
      bg: 'bg-color-darken',
      txt: 'txt-color-white'
    }
  };

  addExternalEvent = () =>{
    let event = {};
    if (this.state.title)
      event.title = this.state.title;
    if (this.state.description)
      event.description = this.state.description;
    event.className = this.state.selectedClassName.bg + ' ' + this.state.selectedClassName.txt;
    this.props.dispatch(addExternal(event));
    this.setState({
      description: '',
      title: ''
    })
  };

  setIcon(icon) {
    this.setState({
      icon: icon
    })
  }

  setTitle(value) {
    this.setState({
      title: value
    })
  }

  setDescription(value) {
    this.setState({
      description: value
    })
  }

  setClassName(className) {
    this.setState({
      selectedClassName: className
    })
  }

  render() {
    let icons = [
      'fa-info',
      'fa-warning',
      'fa-check',
      'fa-user',
      'fa-lock',
      'fa-clock-o'
    ];
    let colorClassNames = [
      {
        bg: 'bg-color-darken',
        txt: 'txt-color-white'
      },
      {
        bg: 'bg-color-blue',
        txt: 'txt-color-white'
      },
      {
        bg: 'bg-color-orange',
        txt: 'txt-color-white'
      },
      {
        bg: 'bg-color-greenLight',
        txt: 'txt-color-white'
      },
      {
        bg: 'bg-color-blueLight',
        txt: 'txt-color-white'
      },
      {
        bg: 'bg-color-red',
        txt: 'txt-color-white'
      }
    ];
    return (
      <form id="add-event-form">
        <fieldset>
          <div className="form-group">
            <label>Select Event Icon</label>
            <ButtonGroup bsSize="small" justified>
              {icons.map((icon, idx)=> {
                return (
                  <label key={'ext-even-icon-' + idx} onClick={this.setIcon.bind(this, icon)}
                         className={classnames('btn', 'btn-default', {
                           active: this.state.icon == icon
                         })}>
                    <i className={classnames('fa', 'text-muted', icon)}/>

                  </label>
                )
              })}
            </ButtonGroup>
          </div>

          <div className="form-group">
            <label>Event Title</label>
            <input
              value={this.state.title}
              onChange={(event) => {
                this.setTitle(event.target.value)
              }}
              className="form-control" id="title"
              name="title" maxLength="40" type="text"
              placeholder="Event Title"/>
          </div>
          <div className="form-group">
            <label>Event Description</label>
            <textarea
              value={this.state.description}
              onChange={(event) => {
                this.setDescription(event.target.value)
              }}
              className="form-control"
              placeholder="Please be brief" rows="3" maxLength="40"
              id="description"/>
            <p className="note">Maxlength is set to 40 characters</p>
          </div>

          <div className="form-group">
            <label>Select Event Color</label>
            <ButtonGroup justified className="btn-select-tick" d>

              {colorClassNames.map((colorClassName, idx)=> {
                return (<label key={'ext-even-color-' + idx} className={classnames('btn', colorClassName.bg, {
                  active: colorClassName.bg == this.state.selectedClassName.bg
                })} onClick={this.setClassName.bind(this, colorClassName)}>
                  <i className={classnames(
                    'fa fa-check', colorClassName.txt
                  )}/>
                </label>)
              })}
            </ButtonGroup>
          </div>

        </fieldset>
        <div className="form-actions">
          <div className="row">
            <div className="col-md-12">
              <button className="btn btn-default" type="button" id="add-event"
                      onClick={this.addExternalEvent}>
                Add Event
              </button>
            </div>
          </div>
        </div>
      </form>
    )
  }
}

export default connect(
  (store)=>(store.events)
)(AddExternalEvent)