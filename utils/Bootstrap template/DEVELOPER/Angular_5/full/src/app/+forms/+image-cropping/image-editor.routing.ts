
import {ModuleWithProviders} from "@angular/core"
import {RouterModule, Routes} from "@angular/router";
import {ImageEditorComponent} from "./image-editor.component";


export const routes:Routes = [

  {
    path: '',
    component: ImageEditorComponent
  },

];

export const routing = RouterModule.forChild(routes);
