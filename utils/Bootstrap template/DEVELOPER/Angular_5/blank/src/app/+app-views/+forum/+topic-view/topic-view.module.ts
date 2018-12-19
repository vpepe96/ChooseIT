import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {TopicViewRoutingModule} from './topic-view-routing.module';
import {TopicViewComponent} from './topic-view.component';
import {SmartadminLayoutModule} from "../../../shared/layout/layout.module";
import {StatsModule} from "../../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    TopicViewRoutingModule,
    SmartadminLayoutModule,
    StatsModule,
  ],
  declarations: [TopicViewComponent]
})
export class TopicViewModule {
}
