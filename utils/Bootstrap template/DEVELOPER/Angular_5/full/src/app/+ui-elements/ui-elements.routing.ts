
import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";

export const routes:Routes = [
  {
    path: '',
    redirectTo: 'buttons',
    pathMatch: 'full',
  },
  { path: 'buttons',loadChildren: 'app/+ui-elements/+buttons/buttons.module#ButtonsModule', data: {pageTitle: 'Buttons'} },
  { path: 'grid',loadChildren: 'app/+ui-elements/+grid/grid.module#GridModule', data: {pageTitle: 'Grid'} },
  { path: 'typography',loadChildren: 'app/+ui-elements/+typography/typography.module#TypographyModule', data: {pageTitle: 'Typography'} },
  { path: 'tree-views',loadChildren: 'app/+ui-elements/+tree-views/tree-views.module#TreeViewsModule', data: {pageTitle: 'Tree Views'} },
  { path: 'nestable-lists',loadChildren: 'app/+ui-elements/+nestable-lists/nestable-lists.module#NestableListsModule', data: {pageTitle: 'Nestable Lists'} },
  { path: 'general',loadChildren: 'app/+ui-elements/+general-elements/general-elements.module#GeneralElementsModule', data: {pageTitle: 'General Elements'} },
  { path: 'icons',loadChildren: 'app/+ui-elements/+icons/icons.module#IconsModule', data: {pageTitle: 'Icons'} },
];

export const routing = RouterModule.forChild(routes)
