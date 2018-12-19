import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-highchart-tables',
  templateUrl: './highchart-tables.component.html',
})
export class HighchartTablesComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
