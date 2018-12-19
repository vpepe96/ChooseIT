
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {TypographyComponent} from "./typography.component";

export const typographyRoutes: Routes = [{
  path: '',
  component: TypographyComponent
}];

export const typographyRouting = RouterModule.forChild(typographyRoutes);

