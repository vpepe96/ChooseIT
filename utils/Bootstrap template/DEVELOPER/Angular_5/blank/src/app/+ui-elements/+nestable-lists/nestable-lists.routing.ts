
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {NestableListsComponent} from "./nestable-lists.component";

export const nestableListsRoutes: Routes = [{
  path: '',
  component: NestableListsComponent
}];

export const nestableListsRouting = RouterModule.forChild(nestableListsRoutes);

