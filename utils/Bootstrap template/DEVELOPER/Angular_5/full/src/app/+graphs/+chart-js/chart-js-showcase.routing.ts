
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {ChartJsShowcaseComponent} from "./chart-js-showcase.component";

export const chartJsShowcaseRoutes: Routes = [
  {
    path: '',
    component: ChartJsShowcaseComponent
  }
];

export const chartJsShowcaseRouting = RouterModule.forChild(chartJsShowcaseRoutes);

