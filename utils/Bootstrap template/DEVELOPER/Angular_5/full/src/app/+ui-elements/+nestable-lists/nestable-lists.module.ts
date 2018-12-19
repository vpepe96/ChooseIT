import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { nestableListsRouting } from './nestable-lists.routing';
import {NestableListsComponent} from "./nestable-lists.component";
import {SmartadminModule} from "../../shared/smartadmin.module";
import {NestableListModule} from "../../shared/ui/nestable-list/nestable-list.module";

@NgModule({
  imports: [
    CommonModule,
    nestableListsRouting,
    SmartadminModule,
    NestableListModule,
  ],
  declarations: [NestableListsComponent]
})
export class NestableListsModule { }
