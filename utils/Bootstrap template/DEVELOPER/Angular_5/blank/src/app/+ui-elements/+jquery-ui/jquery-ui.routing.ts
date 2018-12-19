
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {JqueryUiComponent} from "./jquery-ui.component";

export const jqueryUiRoutes: Routes = [{
  path: '',
  component: JqueryUiComponent
}];

export const jqueryUiRouting = RouterModule.forChild(jqueryUiRoutes);

