import {Component, OnInit} from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-form-layouts',
  templateUrl: './form-layouts.component.html',
})
export class FormLayoutsComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
