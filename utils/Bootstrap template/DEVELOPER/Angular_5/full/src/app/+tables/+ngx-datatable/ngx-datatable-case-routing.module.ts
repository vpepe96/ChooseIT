import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {NgxDatatableCaseComponent} from "./ngx-datatable-case.component";

const routes: Routes = [{
  path: '',
  component: NgxDatatableCaseComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NgxDatatableCaseRoutingModule { }
