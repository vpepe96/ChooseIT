import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GeneralViewRoutingModule} from './general-view-routing.module';
import {GeneralViewComponent} from './general-view.component';
import {SmartadminLayoutModule} from "../../../shared/layout/layout.module";
import {StatsModule} from "../../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    GeneralViewRoutingModule,
    SmartadminLayoutModule,
    StatsModule,
  ],
  declarations: [GeneralViewComponent]
})
export class GeneralViewModule {
}
