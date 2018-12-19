import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LockedRoutingModule } from './locked-routing.module';
import { LockedComponent } from './locked.component';

@NgModule({
  imports: [
    CommonModule,
    LockedRoutingModule
  ],
  declarations: [LockedComponent]
})
export class LockedModule { }
