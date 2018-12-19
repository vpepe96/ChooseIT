import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-easy-pie-charts',
  templateUrl: './easy-pie-charts.component.html',
})
export class EasyPieChartsComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
