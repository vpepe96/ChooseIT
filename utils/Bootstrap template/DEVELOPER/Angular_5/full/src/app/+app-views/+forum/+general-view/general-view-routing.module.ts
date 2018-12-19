import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {GeneralViewComponent} from "./general-view.component";

const routes: Routes = [{
  path: '',
  component: GeneralViewComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class GeneralViewRoutingModule { }
