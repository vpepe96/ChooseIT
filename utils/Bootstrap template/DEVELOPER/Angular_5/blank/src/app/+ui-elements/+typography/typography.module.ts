import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { typographyRouting } from './typography.routing';
import {TypographyComponent} from "./typography.component";
import {SmartadminModule} from "../../shared/smartadmin.module";

@NgModule({
  imports: [
    CommonModule,
    typographyRouting,
    SmartadminModule,
  ],
  declarations: [TypographyComponent]
})
export class TypographyModule { }
