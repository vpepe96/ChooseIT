import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AnalyticsComponent} from "./analytics.component";

const routes: Routes = [{
  path: '',
  component: AnalyticsComponent,
  data: {pageTitle: 'Analytics'}
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class AnalyticsRoutingModule { }
