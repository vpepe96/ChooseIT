
import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";


export const routes:Routes = [

  {
    path: 'normal',
    loadChildren: 'app/+tables/+normal-tables/normal-tables.module#NormalTablesModule',
    data: {pageTitle: 'Normal'}
  },

  {
    path: 'datatables',
    loadChildren: 'app/+tables/+datatables-case/datatables-case.module#DatatablesCaseModule',
    data: {pageTitle: 'Datatables'}
  },

  {
    path: 'ngx-datatable',
    loadChildren: 'app/+tables/+ngx-datatable/ngx-datatable-case.module#NgxDatatableCaseModule',
    data: {pageTitle: 'NGx Datatable'}
  }
];


export const routing = RouterModule.forChild(routes)
