
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {ButtonsComponent} from "./buttons.component";

export const buttonsRoutes: Routes = [{
  path: '',
  component: ButtonsComponent
}];

export const buttonsRouting = RouterModule.forChild(buttonsRoutes);

