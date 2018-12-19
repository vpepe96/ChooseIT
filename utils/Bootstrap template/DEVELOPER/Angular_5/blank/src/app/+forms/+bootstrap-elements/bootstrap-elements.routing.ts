
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {BootstrapElementsComponent} from "./bootstrap-elements.component";

export const bootstrapElementsRoutes: Routes = [{
  path: '',
  component: BootstrapElementsComponent
}];

export const bootstrapElementsRouting = RouterModule.forChild(bootstrapElementsRoutes);

