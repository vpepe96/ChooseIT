
import { NgModule } from '@angular/core';


import { routing } from './smartadmin-intel.routing';
import { AppLayoutsComponent} from './app-layouts/app-layouts.component';
import {PrebuiltSkinsComponent} from "./prebuilt-skins/prebuilt-skins.component";

@NgModule({
  declarations: [
    AppLayoutsComponent,
    PrebuiltSkinsComponent
  ],
  imports: [
    routing
  ],
  entryComponents: [AppLayoutsComponent, PrebuiltSkinsComponent],
})
export class SmartadminIntelModule {

}
