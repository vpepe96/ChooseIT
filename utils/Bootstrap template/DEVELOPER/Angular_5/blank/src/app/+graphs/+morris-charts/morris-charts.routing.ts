
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {MorrisChartsComponent} from "./morris-charts.component";

export const morrisChartsRoutes: Routes = [  {
  path: '',
  component: MorrisChartsComponent
}];

export const morrisChartsRouting = RouterModule.forChild(morrisChartsRoutes);

