import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {CalendarComponent} from "./calendar.component";

export const routes: Routes = [

  {
    path: '',
    component: CalendarComponent,
    data: {pageTitle: 'Calendar'}
  },


];

export const routing = RouterModule.forChild(routes);
