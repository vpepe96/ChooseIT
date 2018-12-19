import {Component, OnInit} from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-bootstrap-validation',
  templateUrl: './bootstrap-validation.component.html',
})
export class BootstrapValidationComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
  }

}
