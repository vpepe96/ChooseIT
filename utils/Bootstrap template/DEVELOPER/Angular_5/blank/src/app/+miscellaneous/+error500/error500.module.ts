import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Error500RoutingModule } from './error500-routing.module';
import { Error500Component } from './error500.component';
import {SmartadminLayoutModule} from "../../shared/layout/layout.module";
import {StatsModule} from "../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    Error500RoutingModule,


    SmartadminLayoutModule,
		StatsModule,

  ],
  declarations: [Error500Component]
})
export class Error500Module { }
