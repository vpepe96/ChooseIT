import {ModuleWithProviders} from "@angular/core"
import {Routes, RouterModule} from "@angular/router";

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'blank',
    pathMatch: 'full'
  },

  {
    path: 'blank',
    loadChildren: './+blank/blank.module#BlankModule'
  },
  {
    path: 'ckeditor',
    loadChildren: './+ckeditor/ckeditor.module#CkeditorModule'
  },
  {
    path: 'email-template',
    loadChildren: './+email-template/email-template.module#EmailTemplateModule'
  },
  {
    path: 'error404',
    loadChildren: './+error404/error404.module#Error404Module'
  },
  {
    path: 'error500',
    loadChildren: './+error500/error500.module#Error500Module'
  },
  {
    path: 'invoice',
    loadChildren: './+invoice/invoice.module#InvoiceModule'
  },
  {
    path: 'pricing-tables',
    loadChildren: './+pricing-tables/pricing-tables.module#PricingTablesModule'
  },
  {
    path: 'search',
    loadChildren: './+search/search.module#SearchModule'
  },
];

export const routing = RouterModule.forChild(routes);




