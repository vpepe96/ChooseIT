
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {WizardsComponent} from "./wizards.component";

export const wizardsRoutes: Routes = [{
  path: '',
  component: WizardsComponent
}];

export const wizardsRouting = RouterModule.forChild(wizardsRoutes);

