import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-app-layouts',
  templateUrl: './app-layouts.component.html',
})
export class AppLayoutsComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
