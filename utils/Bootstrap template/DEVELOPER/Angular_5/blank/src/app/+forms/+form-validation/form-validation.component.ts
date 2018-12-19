import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-form-validation',
  templateUrl: './form-validation.component.html',
})
export class FormValidationComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
