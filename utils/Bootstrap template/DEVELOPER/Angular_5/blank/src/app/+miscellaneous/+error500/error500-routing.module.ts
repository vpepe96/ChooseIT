import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Error500Component} from "./error500.component";

const routes: Routes = [{
  path: '',
  component: Error500Component
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class Error500RoutingModule { }
