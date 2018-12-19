import React from 'react'

import {GoogleMap, Marker} from "react-google-maps";
import ScriptjsLoader from "../../../../../node_modules/react-google-maps/lib/async/ScriptjsLoader";

let _mapInstances = {};
let _counter = 0;

export default class MapView extends React.Component {
  state = {
    style: null,
    instanceId: '_mapInstances' + (++_counter)
  };

  componentWillMount() {
    this.getStyle(this.props.params.style)
  }

  componentWillReceiveProps(nextProps) {
    this.getStyle(nextProps.params.style)
  }

  getStyle(style) {
    $.getJSON('assets/api/maps/' + style + '.json')
      .then(this.setStyle)
  }

  setStyle = (data) => {
    let map = _mapInstances[this.state.instanceId];
    if (map) {
      map.setOptions({
        styles: data
      });
      google.maps.event.trigger(map, 'resize')
    } else {
      this.setState({
        style: data
      })
    }

  }

  componentWillUnmount() {
    delete _mapInstances[this.state.instanceId]
  }

  render() {
    return (
      <section style={{minHeight: "400px"}}>
        {this.state.style ?
          <ScriptjsLoader
            hostname={"maps.googleapis.com"}
            pathname={"/maps/api/js"}
            query={{v: `3.22`, libraries: "geometry,drawing,places"}}
            loadingElement={
              <div>
                <i className="fa fa-gear fa-spinner"/>
              </div>
            }
            containerElement={
              <div style={{minHeight: "400px"}}/>
            }
            googleMapElement={
              <GoogleMap
                defaultZoom={3}
                defaultCenter={{lat: -25.363882, lng: 131.044922}}
                defaultOptions={{
                  styles: this.state.style
                }}
                ref={googleMap => {
                  if (!googleMap) {
                    return;
                  }
                  _mapInstances[this.state.instanceId] = googleMap.props.map
                }}
              />
            }
          /> : null}
      </section>
    )
  }
}