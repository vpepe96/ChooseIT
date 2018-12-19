import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LockedComponent} from "./locked.component";

const routes: Routes = [{
  path: '',
  component: LockedComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class LockedRoutingModule { }
