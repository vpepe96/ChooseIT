import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-blank',
  templateUrl: './blank.component.html',
})
export class BlankComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
