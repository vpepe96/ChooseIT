import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GalleryDemoComponent} from "./gallery-demo.component";

const routes: Routes = [{
  path: '',
  component: GalleryDemoComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class GalleryDemoRoutingModule { }
