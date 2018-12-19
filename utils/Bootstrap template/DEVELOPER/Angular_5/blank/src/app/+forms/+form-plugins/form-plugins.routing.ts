
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {FormPluginsComponent} from "./form-plugins.component";

export const formPluginsRoutes: Routes = [{
  path: '',
  component: FormPluginsComponent
}];

export const formPluginsRouting = RouterModule.forChild(formPluginsRoutes);

