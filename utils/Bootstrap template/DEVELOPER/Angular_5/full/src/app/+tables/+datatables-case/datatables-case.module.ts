import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {SmartadminModule} from "../../shared/smartadmin.module";
import {DatatablesCaseComponent} from "./datatables-case.component";
import {SmartadminDatatableModule} from "../../shared/ui/datatable/smartadmin-datatable.module";
import { DatatablesRestDemoComponent } from './datatables-rest-demo.component';
import {DatatablesCaseRoutingModule} from "./datatables-case-routing.module";

@NgModule({
  imports: [
    CommonModule,
    SmartadminModule,
    SmartadminDatatableModule,
    DatatablesCaseRoutingModule
  ],
  declarations: [
     DatatablesCaseComponent, DatatablesRestDemoComponent
  ]
})
export class DatatablesCaseModule { }
