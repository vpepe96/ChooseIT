import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { bootstrapElementsRouting } from './bootstrap-elements.routing';
import {BootstrapElementsComponent} from "./bootstrap-elements.component";
import {SmartadminModule} from "../../shared/smartadmin.module";

@NgModule({
  imports: [
    CommonModule,
    bootstrapElementsRouting,
    SmartadminModule
  ],
  declarations: [BootstrapElementsComponent]
})
export class BootstrapElementsModule { }
