import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NormalTablesRoutingModule } from './normal-tables-routing.module';
import { NormalTablesComponent } from "app/+tables/+normal-tables/normal-tables.component";
import {SmartadminModule} from "app/shared/smartadmin.module";

@NgModule({
  imports: [
    CommonModule,
    SmartadminModule,
    NormalTablesRoutingModule
  ],
  declarations: [
    NormalTablesComponent
  ]
})
export class NormalTablesModule { }
