import {Component, OnInit, OnDestroy} from '@angular/core';
import {GoogleAPIService, MapStyleService} from "./shared";
import {fadeInTop} from "../shared/animations/router.animations";

declare var google: any;

@Component({
  selector: 'sa-maps',
  templateUrl: './maps.component.html',
})
export class MapsComponent implements OnInit, OnDestroy {

  public styles = [
    {key: 'colorful', name: 'Colorful', url: '/maps/colorful.json'},
    {key: 'greyscale', name: 'Greyscale', url: '/maps/greyscale.json'},
    {key: 'metro', name: 'Metro', url: '/maps/metro.json'},
    {key: 'mono-color', name: 'Mono-color', url: '/maps/mono-color.json'},
    {key: 'monochrome', name: 'Monochrome', url: '/maps/monochrome.json'},
    {key: 'nightvision', name: 'Nightvision', url: '/maps/nightvision.json'},
    {
      key: 'nightvision-highlight',
      name: 'Nightvision Highlight',
      url: '/maps/nightvision-highlight.json'
    },
    {key: 'old-paper', name: 'Old Paper', url: '/maps/old-paper.json'}
  ];


  public activeStyle: any;

  public map: any;

  constructor(private apiService:GoogleAPIService, private styleService: MapStyleService) {

  }

  ngOnInit() {
    this.activeStyle = this.styles[0];

    this.apiService.loadAPI.then((google: any)=>{
      this.map = new google.maps.Map(document.getElementById('map-canvas'), {
        center: {lat: -34.397, lng: 150.644},
        zoom: 8
      });

      this.fetchStyle(this.activeStyle)
    })
  }

  ngOnDestroy(){
  }

  setStyle(style) {
    this.activeStyle = style;
    this.fetchStyle(style)
  }

  fetchStyle(style) {
    this.styleService.fetchStyle(style).subscribe((styleDef)=>{
      this.map.mapTypes.set(style.key,
        new google.maps.StyledMapType(styleDef,
          {name: style.name})
      );
      this.map.setMapTypeId(style.key);
    })
  }

}
