import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { formValidationRouting } from './form-validation.routing';
import {SmartadminModule} from "../../shared/smartadmin.module";
import {FormValidationComponent} from "./form-validation.component";

@NgModule({
  imports: [
    CommonModule,
    formValidationRouting,
    SmartadminModule
  ],
  declarations: [FormValidationComponent]
})
export class FormValidationModule { }
