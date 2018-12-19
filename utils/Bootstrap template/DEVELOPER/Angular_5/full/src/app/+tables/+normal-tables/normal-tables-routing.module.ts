import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NormalTablesComponent } from "app/+tables/+normal-tables/normal-tables.component";

const routes: Routes = [{
  path: '',
  component: NormalTablesComponent,
}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NormalTablesRoutingModule { }
