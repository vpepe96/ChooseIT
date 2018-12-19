
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {HighchartTablesComponent} from "./highchart-tables.component";

export const highchartTablesRoutes: Routes = [  {
  path: '',
  component: HighchartTablesComponent
}];

export const highchartTablesRouting = RouterModule.forChild(highchartTablesRoutes);

