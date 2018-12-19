import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-error404',
  templateUrl: './error404.component.html',
})
export class Error404Component implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
