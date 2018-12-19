
import {ModuleWithProviders} from "@angular/core"
import {Routes, RouterModule} from '@angular/router';
import {DygraphsComponent} from "./dygraphs.component";

export const dygraphsRoutes: Routes = [
  {
    path: '',
    component: DygraphsComponent
  }
];

export const dygraphsRouting = RouterModule.forChild(dygraphsRoutes);

