import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { iconsRouting } from './icons.routing';
import {FontAwesomeComponent} from "./+font-awesome/font-awesome.component";
import {FlagsComponent} from "./+flags/flags.component";
import {GlyphiconsComponent} from "./+glyphicons/glyphicons.component";
import {SmartadminModule} from "../../shared/smartadmin.module";

@NgModule({
  imports: [
    CommonModule,
    iconsRouting,
    SmartadminModule
  ],
  declarations: [FlagsComponent, FontAwesomeComponent, GlyphiconsComponent]
})
export class IconsModule { }
