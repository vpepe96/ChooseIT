import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {EmailTemplateComponent} from './email-template.component'

const routes: Routes = [{
  path: '',
  component: EmailTemplateComponent
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: []
})
export class EmailTemplateRoutingModule { }
