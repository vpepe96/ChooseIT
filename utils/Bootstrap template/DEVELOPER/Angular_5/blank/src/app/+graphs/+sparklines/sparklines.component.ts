import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-sparklines',
  templateUrl: './sparklines.component.html',
})
export class SparklinesComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
