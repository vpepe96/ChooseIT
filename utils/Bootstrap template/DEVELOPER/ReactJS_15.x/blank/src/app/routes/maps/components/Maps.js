import React from 'react'
import {Link} from 'react-router'

import {Stats, BigBreadcrumbs, WidgetGrid, JarvisWidget}  from '../../../components'


export default class Maps extends React.Component {
  static defaultProps = {
    styles: {
      'colorful': {name: 'Colorful', url: 'assets/api/maps/colorful.json'},
      'greyscale': {name: 'greyscale', url: 'assets/api/maps/greyscale.json'},
      'metro': {name: 'metro', url: 'assets/api/maps/metro.json'},
      'mono-color': {name: 'mono-color', url: 'assets/api/maps/mono-color.json'},
      'monochrome': {name: 'monochrome', url: 'assets/api/maps/monochrome.json'},
      'nightvision': {name: 'Nightvision', url: 'assets/api/maps/nightvision.json'},
      'nightvision-highlight': {
        name: 'nightvision-highlight',
        url: 'assets/api/maps/nightvision-highlight.json'
      },
      'old-paper': {name: 'Old Paper', url: 'assets/api/maps/old-paper.json'}
    }
  };

  state = {
    current: this.props.params
  };

  render() {
    return (
      <div id="content">
        <div className="row">
          <BigBreadcrumbs items={['Google Map', 'Custom Skins']} icon="fa fa-fw fa-map-marker"
                          className="col-xs-12 col-sm-7 col-md-7 col-lg-4"/>
          <Stats className="hidden-xs"/>
        </div>


        <div className="row">
          <div className="col-xs-12">
            { Object.keys(this.props.styles).map((key) => {
              return (
                <Link className="btn btn-default" to={'/maps/' + key} key={'map-' + key}
                      activeClassName="active">{this.props.styles[key].name}</Link>
              )
            }) }
          </div>
          <hr/>
        </div>

        <WidgetGrid>
          <div className="row">
            <article className="col-xs-12 col-sm-12 col-md-12 col-lg-12">
              <JarvisWidget
                editbutton={false}
                deletebutton={false}
                fullscreenbutton={false}
                color="white"
                style={{marginBottom: 0}}>
                <header>
                  <span className="widget-icon"> <i className="fa fa-map-marker"/> </span>
                  <h2>Map demo</h2>
                </header>
                <div>
                  <div className="widget-body no-padding">

                    {this.props.children}

                  </div>
                </div>
              </JarvisWidget>
            </article>
          </div>
        </WidgetGrid>
      </div>
    )
  }
}