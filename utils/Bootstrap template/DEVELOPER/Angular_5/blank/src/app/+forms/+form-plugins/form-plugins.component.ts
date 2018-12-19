import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-form-plugins',
  templateUrl: './form-plugins.component.html',
})
export class FormPluginsComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

  noUiSliderValue = [264, 776];

}
