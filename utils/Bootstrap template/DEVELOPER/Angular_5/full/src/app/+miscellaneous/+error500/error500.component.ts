import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-error500',
  templateUrl: './error500.component.html',
})
export class Error500Component implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
