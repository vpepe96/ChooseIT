
import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {MapsComponent} from "./maps.component";


export const routes:Routes = [

  {
    path: '',
    component: MapsComponent
  },

];

export const routing = RouterModule.forChild(routes);
