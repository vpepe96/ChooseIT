
import {ModuleWithProviders} from "@angular/core"
import {Routes, RouterModule} from '@angular/router';

import {AppLayoutsComponent} from './app-layouts/app-layouts.component'
import {PrebuiltSkinsComponent} from './prebuilt-skins/prebuilt-skins.component'

export const routes:Routes =  [
    {path: '', redirectTo: 'app-layouts', pathMatch: 'full'},
    {path: 'app-layouts', component: AppLayoutsComponent},
    {path: 'prebuilt-skins', component: PrebuiltSkinsComponent}
  ]

export const routing = RouterModule.forChild(routes);
