import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {Error404Component} from "./error404.component";

const routes: Routes = [{
  path: '',
  component: Error404Component
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class Error404RoutingModule { }
