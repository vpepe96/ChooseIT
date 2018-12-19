import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { dygraphsRouting } from './dygraphs.routing';
import { DygraphsComponent } from './dygraphs.component';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {DygraphModule} from "../../shared/graphs/dygraph/dygraph.module";

@NgModule({
  imports: [
    CommonModule,
    dygraphsRouting,
    SmartadminModule,
    DygraphModule
  ],
  declarations: [DygraphsComponent]
})
export class DygraphsModule { }
