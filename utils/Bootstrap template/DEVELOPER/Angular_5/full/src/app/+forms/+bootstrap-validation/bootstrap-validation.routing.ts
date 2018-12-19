
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {BootstrapValidationComponent} from "./bootstrap-validation.component";

export const bootstrapValidationRoutes: Routes = [{
  path: '',
  component: BootstrapValidationComponent
}];

export const bootstrapValidationRouting = RouterModule.forChild(bootstrapValidationRoutes);

