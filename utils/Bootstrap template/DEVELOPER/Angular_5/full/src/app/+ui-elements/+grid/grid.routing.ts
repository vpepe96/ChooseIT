
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {GridComponent} from "./grid.component";

export const gridRoutes: Routes = [{
  path: '',
  component: GridComponent
}];

export const gridRouting = RouterModule.forChild(gridRoutes);

