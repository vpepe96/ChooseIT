import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PricingTablesComponent} from "./pricing-tables.component";

const routes: Routes = [{
  path: '',
  component: PricingTablesComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class PricingTablesRoutingModule { }
