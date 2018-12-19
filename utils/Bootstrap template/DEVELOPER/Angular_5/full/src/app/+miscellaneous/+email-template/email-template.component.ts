import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-email-template',
  templateUrl: './email-template.component.html',
})
export class EmailTemplateComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
