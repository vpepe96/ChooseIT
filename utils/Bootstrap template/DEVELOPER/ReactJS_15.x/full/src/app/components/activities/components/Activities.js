import React from 'react'
import classnames from 'classnames'
import Moment from '../../utils/Moment'
import getJSON from '../../utils/getJSON'
import Message from './Message'
import Notification from './Notification'
import Task from './Task'

const Components = {
  message: Message,
  notification: Notification,
  task: Task
};

export default class Activities extends React.Component {
  state = {
    activity: {
      data: []
    },
    activities: [],
    lastUpdate: new Date()
  };
  _active = false;

  render() {
    const activities = this.state.activities;
    const activity = this.state.activity;

    const count = activities.reduce((sum, a)=>(sum + a.data.length), 0);

    return (
      <div>
                <span id="activity" onClick={this.toggleDropdown} ref="dropdownToggle" className="activity-dropdown">
                    <i className="fa fa-user"/>
                    <b className="badge bg-color-red">{count}</b>
                </span>
        <div className="ajax-dropdown" ref="dropdown">

          <div className="btn-group btn-group-justified" data-toggle="buttons">
            {activities.map((_activity, idx) => {
              return (
                <label className={classnames(["btn", "btn-default", {
                  active: _activity.name == activity.name
                }])} key={idx} onClick={this.setActivity.bind(this, _activity)}
                >
                  <input type="radio" name="activity"/>
                  {_activity.title} ({_activity.data.length+1})
                </label>

              )
            })}
          </div>

          {/* notification content */}
          <div className="ajax-notifications custom-scroll">
            <ul className="notification-body">
              {activity.data.map((item, idx) => {
                let component = Components[item.type]
                return <li key={idx}>{React.createElement(component, {
                  item: item,
                  lastUpdated: this.state.lastUpdated
                })}</li>
              })}
            </ul>
          </div>
          {/* end notification content */}

          {/* footer: refresh area */}
          <span> Last updated on: <Moment data={this.state.lastUpdate} format="h:mm:ss a"/>
                  <button type="button" onClick={this.update}
                          className="btn btn-xs btn-default pull-right">
                      <i ref="loadingSpin" className="fa fa-refresh"/>
                      <span ref="loadingText"/>
                  </button>
                  </span>
          {/* end footer */}

        </div>
      </div>
    )
  }

  setActivity = (activity) => {
    this.setState({
      activity
    })
  };

  toggleDropdown = (e) =>{
    e.preventDefault();
    const $dropdown = $(this.refs.dropdown);
    const $dropdownToggle = $(this.refs.dropdownToggle);

    if (this._active) {
      $dropdown.fadeOut(150)
    } else {
      $dropdown.fadeIn(150)
    }

    this._active = !this._active;
    $dropdownToggle.toggleClass('active', this._active)
  };

  componentWillMount() {
    this.fetch()
  }

  update = () => {
    $(this.refs.loadingText).html('Loading...');
    $(this.refs.loadingSpin).addClass('fa-spin');
    this.fetch().then(() =>{
      $(this.refs.loadingText).html('');
      $(this.refs.loadingSpin).removeClass('fa-spin');
    })
  };

  fetch = ()=> {
    return getJSON('assets/api/activities/activities.json').then( (activities) => {

      this.setState({
        activities: activities,
        activity: activities[0],
        lastUpdate: new Date()
      })
    })
  }

}