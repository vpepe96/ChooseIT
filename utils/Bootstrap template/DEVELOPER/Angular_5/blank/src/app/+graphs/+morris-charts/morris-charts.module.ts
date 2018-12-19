import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { morrisChartsRouting } from './morris-charts.routing';
import { MorrisChartsComponent } from './morris-charts.component';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {MorrisGraphModule} from "../../shared/graphs/morris-graph/morris-graph.module";

@NgModule({
  imports: [
    CommonModule,
    morrisChartsRouting,
    SmartadminModule,
    MorrisGraphModule
  ],
  declarations: [MorrisChartsComponent]
})
export class MorrisChartsModule { }
