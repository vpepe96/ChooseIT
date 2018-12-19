import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-form-elements',
  templateUrl: './form-elements.component.html',
})
export class FormElementsComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
