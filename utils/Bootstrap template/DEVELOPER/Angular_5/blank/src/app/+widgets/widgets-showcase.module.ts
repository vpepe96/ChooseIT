import {NgModule} from "@angular/core";

import {SmartadminModule} from "../shared/smartadmin.module";
import {routing} from "./widgets-showcase.routing";
import {WidgetsShowcaseComponent} from "./widgets-showcase.component";



@NgModule({
  declarations: [
    WidgetsShowcaseComponent
  ],
  imports: [
    SmartadminModule,
    routing
  ],
  providers: [],
})
export class WidgetsShowcaseModule {

}
