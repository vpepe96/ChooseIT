import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InvoiceRoutingModule } from './invoice-routing.module';
import { InvoiceComponent } from './invoice.component';
import {SmartadminLayoutModule} from "../../shared/layout/layout.module";
import {StatsModule} from "../../shared/stats/stats.module";
import {SmartadminWidgetsModule} from "../../shared/widgets/smartadmin-widgets.module";

@NgModule({
  imports: [
    CommonModule,
    InvoiceRoutingModule,

    SmartadminLayoutModule,
		StatsModule,
    SmartadminWidgetsModule,
  ],
  declarations: [InvoiceComponent]
})
export class InvoiceModule { }
