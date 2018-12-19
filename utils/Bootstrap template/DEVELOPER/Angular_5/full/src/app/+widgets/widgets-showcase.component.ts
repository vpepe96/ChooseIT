import { Component, OnInit } from '@angular/core';
import {fadeInTop} from "../shared/animations/router.animations";

@Component({
  selector: 'sa-widgets-showcase',
  templateUrl: './widgets-showcase.component.html',
})
export class WidgetsShowcaseComponent implements OnInit {

  demoStyle = 'style1';

  demoShowTabs = false;


  setStyle(style){
    this.demoStyle = style
  }

  constructor() {}

  ngOnInit() {
  }

}
