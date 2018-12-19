import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { highchartTablesRouting } from './highchart-tables.routing';
import { HighchartTablesComponent } from './highchart-tables.component';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {HighchartsModule} from "../../shared/graphs/highcharts/highcharts.module";

@NgModule({
  imports: [
    CommonModule,
    highchartTablesRouting,
    SmartadminModule,
    HighchartsModule
  ],
  declarations: [HighchartTablesComponent]
})
export class HighchartTablesModule { }
