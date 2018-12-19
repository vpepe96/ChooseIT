import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-pricing-tables',
  templateUrl: './pricing-tables.component.html',
})
export class PricingTablesComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
