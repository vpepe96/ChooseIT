import React from 'react'

import _ from 'lodash'

// import NavigationStore from '../stores/NavigationStore'

export default class BigBreadcrumbs extends React.Component {
  // mixins: [Reflux.listenTo(NavigationStore, 'onNavigationChange')],

  constructor(props) {
    super(props);
    this.state = {
      items: this.props.items || [],
      icon: this.props.icon || 'fa fa-fw fa-home'
    }
  }


  componentWillMount() {
    // if(!this.props.items && NavigationStore.getData().item){
    //     this.onNavigationChange({
    //         item: NavigationStore.getData().item
    //     })
    // }
  }

  onNavigationChange(data) {
    let item = data.item;
    if (item.route) {
      this.state.items = [];
      this.state.icon = '';
      this._addCrumb(item);
      this.forceUpdate()
    }

  }

  _addCrumb(item) {
    this.state.items.unshift(item.title)
    if (!this.state.icon && item.icon)
      this.state.icon = item.icon
    if (item.parent)
      this._addCrumb(item.parent)
  }

  render() {
    const first = _.head(this.state.items);




    return (
      <div className={this.props.className + ' big-breadcrumbs'}>
        <h1 className="page-title txt-color-blueDark">
          <i className={this.state.icon}/>{' ' + first}
          {_.tail(this.state.items).map((item) => {
            return <span key={_.uniqueId('big-breadcrumb-')}>
                            <span className="page-title-separator">&gt;</span>
              {item}</span>
          })}
        </h1>
      </div>
    )
  }
}