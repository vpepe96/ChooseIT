

import {NgModule} from "@angular/core";
import {SmartadminModule} from "../shared/smartadmin.module";
import {MapsComponent} from "./maps.component";
import {MapStyleService} from "./shared/map-style.service";
import {GoogleAPIService} from "./shared/google-api.service";
import {routing} from "./maps.routing";

@NgModule({
  imports: [routing, SmartadminModule],
  declarations: [MapsComponent],
  exports: [MapsComponent],
  providers: [GoogleAPIService, MapStyleService],
})
export class MapsModule{}
