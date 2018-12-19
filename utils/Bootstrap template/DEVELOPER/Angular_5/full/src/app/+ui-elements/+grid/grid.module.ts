import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { gridRouting } from './grid.routing';
import {GridComponent} from "./grid.component";
import {SmartadminModule} from "../../shared/smartadmin.module";

@NgModule({
  imports: [
    CommonModule,
    gridRouting,
    SmartadminModule,
  ],
  declarations: [GridComponent]
})
export class GridModule { }
