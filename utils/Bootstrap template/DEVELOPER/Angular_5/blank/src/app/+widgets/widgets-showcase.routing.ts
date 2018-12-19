
import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {WidgetsShowcaseComponent} from "./widgets-showcase.component";


export const routes:Routes = [

  {
    path: '',
    component: WidgetsShowcaseComponent
  },

];

export const routing = RouterModule.forChild(routes);
