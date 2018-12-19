
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {FormElementsComponent} from "./form-elements.component";

export const formElementsRoutes: Routes = [{
  path: '',
  component: FormElementsComponent
}];

export const formElementsRouting = RouterModule.forChild(formElementsRoutes);

