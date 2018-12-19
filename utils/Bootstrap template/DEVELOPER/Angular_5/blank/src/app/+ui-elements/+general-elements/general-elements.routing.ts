
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {GeneralElementsComponent} from "./general-elements.component";

export const generalElementsRoutes: Routes = [{
  path: '',
  component: GeneralElementsComponent
}];

export const generalElementsRouting = RouterModule.forChild(generalElementsRoutes);

