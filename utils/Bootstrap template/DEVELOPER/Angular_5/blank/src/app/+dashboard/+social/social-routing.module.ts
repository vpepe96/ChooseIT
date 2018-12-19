import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SocialComponent} from "./social.component";

const routes: Routes = [{
  path: '',
  component: SocialComponent,
  data: {pageTitle: 'Social'}
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class SocialRoutingModule { }
