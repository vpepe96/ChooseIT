
import {ModuleWithProviders} from "@angular/core"
import {FontAwesomeComponent} from "./+font-awesome/font-awesome.component";
import {GlyphiconsComponent} from "./+glyphicons/glyphicons.component";
import {FlagsComponent} from "./+flags/flags.component";
import {Routes, RouterModule} from "@angular/router";

export const iconsRoutes:Routes = [{
      path: 'font-awesome',
      component: FontAwesomeComponent
    },
    {
      path: 'glyphicons',
      component: GlyphiconsComponent

    },
    {
      path: 'flags',
      component: FlagsComponent
    }
  ];

export const iconsRouting = RouterModule.forChild(iconsRoutes);
