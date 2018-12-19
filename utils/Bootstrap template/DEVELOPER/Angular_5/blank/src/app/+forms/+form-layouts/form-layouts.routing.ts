
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {FormLayoutsComponent} from "./form-layouts.component";

export const formLayoutsRoutes: Routes = [{
  path: '',
  component: FormLayoutsComponent
}];

export const formLayoutsRouting = RouterModule.forChild(formLayoutsRoutes);

