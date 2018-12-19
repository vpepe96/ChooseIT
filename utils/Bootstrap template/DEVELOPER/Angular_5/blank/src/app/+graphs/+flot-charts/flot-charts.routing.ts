
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {FlotChartsComponent} from "./flot-charts.component";

export const flotChartsRoutes: Routes = [
  {
    path: '',
    component: FlotChartsComponent
  },
];

export const flotChartsRouting = RouterModule.forChild(flotChartsRoutes);

