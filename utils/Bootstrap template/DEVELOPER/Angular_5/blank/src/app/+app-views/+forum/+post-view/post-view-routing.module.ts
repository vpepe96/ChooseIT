import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PostViewComponent} from "./post-view.component";

const routes: Routes = [{
  path: '',
  component: PostViewComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class PostViewRoutingModule { }
