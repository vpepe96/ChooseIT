import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { formElementsRouting } from './form-elements.routing';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {FormElementsComponent} from "./form-elements.component";

@NgModule({
  imports: [
    CommonModule,
    formElementsRouting,
    SmartadminModule
  ],
  declarations: [FormElementsComponent]
})
export class FormElementsModule { }
