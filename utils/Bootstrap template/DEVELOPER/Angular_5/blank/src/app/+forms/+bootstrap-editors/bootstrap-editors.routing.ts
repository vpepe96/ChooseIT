
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {BootstrapEditorsComponent} from "./bootstrap-editors.component";

export const bootstrapEditorsRoutes: Routes = [{
  path: '',
  component: BootstrapEditorsComponent
}];

export const bootstrapEditorsRouting = RouterModule.forChild(bootstrapEditorsRoutes);

