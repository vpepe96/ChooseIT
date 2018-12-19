import React from 'react'
import classnames from 'classnames'


export default  class ChatUsers extends React.Component {
  state = {
    open: false,
    filter: ''
  }

  _openToggle = ()=> {
    this.setState({
      open: !this.state.open
    })
  }

  _messageTo(user) {
    // ChatActions.messageTo(user)
  }

  onFilterChange(value) {
    this.setState({
      filter: value
    })
  }

  render() {

    const filter = this.state.filter.trim();

    return (
      <div id="chat-container" className={classnames({
        open: this.state.open
      })}>
                <span className="chat-list-open-close" onClick={this._openToggle}><i
                  className="fa fa-user"/><b>!</b></span>

        <div className="chat-list-body custom-scroll">
          <ul id="chat-users">
            {
              (this.props.users || [])
                .filter((user) => {
                  return !filter || user.username.toLowerCase().search(filter.toLowerCase()) > -1
                })
                .map((user, idx) =>{
                  const statusColorClass = (user.status == 'online' ? 'txt-color-green' :
                    (user.status == 'away' ? 'txt-color-orange' :
                      (user.status == 'busy' ? 'txt-color-red' :
                        'txt-color-white')))
                  return (
                    <li key={'chat-user-' + idx}>
                      <a onClick={this._messageTo.bind(this, user)}><img
                        src={user.picture}/>{user.username} <span
                        className="badge badge-inverse">{user.username.length}</span><span
                        className="state"><i
                        className={classnames(
                          'fa', 'fa-circle', 'pull-right', statusColorClass
                        )}/></span></a>
                    </li>
                  )
                })
            }
          </ul>
        </div>
        <div className="chat-list-footer">
          <div className="control-group">
            <form className="smart-form">
              <section>
                <label className="input">
                  <input type="text"
                         value={this.state.filter}
                         onChange={event => this.onFilterChange(event.target.value)}
                         id="filter-chat-list"
                         placeholder="Filter"/>
                </label>
              </section>
            </form>
          </div>
        </div>
      </div>
    )
  }
}