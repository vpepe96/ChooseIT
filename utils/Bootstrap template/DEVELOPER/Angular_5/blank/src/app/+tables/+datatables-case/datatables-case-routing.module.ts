import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DatatablesCaseComponent} from "./datatables-case.component";

const routes: Routes = [{
  path: '',
  component: DatatablesCaseComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DatatablesCaseRoutingModule { }
