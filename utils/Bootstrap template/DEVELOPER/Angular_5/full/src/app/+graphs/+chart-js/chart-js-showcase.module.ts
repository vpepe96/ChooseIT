import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { chartJsShowcaseRouting } from './chart-js-showcase.routing';
import { ChartJsShowcaseComponent } from './chart-js-showcase.component';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {ChartJsModule} from "../../shared/graphs/chart-js/chart-js.module";

@NgModule({
  imports: [
    CommonModule,
    chartJsShowcaseRouting,
    SmartadminModule,
    ChartJsModule,
  ],
  declarations: [ChartJsShowcaseComponent]
})
export class ChartJsShowcaseModule { }
