import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PricingTablesRoutingModule } from './pricing-tables-routing.module';
import { PricingTablesComponent } from './pricing-tables.component';
import {SmartadminLayoutModule} from "../../shared/layout/layout.module";
import {StatsModule} from "../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    PricingTablesRoutingModule,


    SmartadminLayoutModule,
		StatsModule,
  ],
  declarations: [PricingTablesComponent]
})
export class PricingTablesModule { }
