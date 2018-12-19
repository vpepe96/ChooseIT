
import {ModuleWithProviders} from "@angular/core"
import { Routes, RouterModule } from '@angular/router';
import {TreeViewsComponent} from "./tree-views.component";

export const treeViewsRoutes: Routes = [{
  path: '',
  component: TreeViewsComponent
}];

export const treeViewsRouting = RouterModule.forChild(treeViewsRoutes);

