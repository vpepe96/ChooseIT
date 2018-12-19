import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {GalleryDemoRoutingModule} from './gallery-demo-routing.module';
import {GalleryDemoComponent} from './gallery-demo.component';
import {SmartadminGalleryModule} from "../../shared/ui/gallery/gallery.module";
import {SmartadminLayoutModule} from "../../shared/layout/layout.module";
import {StatsModule} from "../../shared/stats/stats.module";

@NgModule({
  imports: [
    CommonModule,
    GalleryDemoRoutingModule,
    SmartadminGalleryModule,
    SmartadminLayoutModule,
    StatsModule,

  ],
  declarations: [GalleryDemoComponent]
})
export class GalleryDemoModule {
}
