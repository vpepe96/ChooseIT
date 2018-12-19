
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {FormValidationComponent} from "./form-validation.component";

export const formValidationRoutes: Routes = [{
  path: '',
  component: FormValidationComponent
}];

export const formValidationRouting = RouterModule.forChild(formValidationRoutes);

