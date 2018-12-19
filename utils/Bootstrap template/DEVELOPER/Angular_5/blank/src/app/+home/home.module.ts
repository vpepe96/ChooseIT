import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { homeRouting } from './home.routing';
import {SmartadminModule} from "../shared/smartadmin.module";
import {HomeComponent} from "./home.component";

@NgModule({
  imports: [
    CommonModule,
    homeRouting,
      SmartadminModule
  ],
  declarations: [HomeComponent]
})
export class HomeModule { }
