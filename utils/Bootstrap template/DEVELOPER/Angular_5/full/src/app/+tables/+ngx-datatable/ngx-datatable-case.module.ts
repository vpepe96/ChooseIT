import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NgxDatatableCaseRoutingModule } from './ngx-datatable-case-routing.module';
import {NgxDatatableCaseComponent} from "./ngx-datatable-case.component";
import {SmartadminModule} from "../../shared/smartadmin.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import { RowDetailComponent } from './row-detail/row-detail.component';
import { PagedTableComponent } from './paged-table/paged-table.component';



@NgModule({
  imports: [
    CommonModule,
    NgxDatatableCaseRoutingModule,
    NgxDatatableModule,
    SmartadminModule,
  ],
  declarations: [NgxDatatableCaseComponent, RowDetailComponent, PagedTableComponent]
})
export class NgxDatatableCaseModule { }
