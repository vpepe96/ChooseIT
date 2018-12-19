import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimelineComponent} from "./timeline.component";

const routes: Routes = [{
  path: '',
  component: TimelineComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class TimelineRoutingModule { }
