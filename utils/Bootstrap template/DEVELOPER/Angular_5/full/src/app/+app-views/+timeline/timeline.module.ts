import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TimelineRoutingModule} from './timeline-routing.module';
import {TimelineComponent} from './timeline.component';
import {SmartadminLayoutModule} from "../../shared/layout/layout.module";
import {StatsModule} from "../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    SmartadminLayoutModule,
    StatsModule,
    TimelineRoutingModule
  ],
  declarations: [TimelineComponent]
})
export class TimelineModule {
}
