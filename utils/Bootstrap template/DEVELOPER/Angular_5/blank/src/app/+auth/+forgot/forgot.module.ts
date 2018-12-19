import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ForgotRoutingModule } from './forgot-routing.module';
import { ForgotComponent } from './forgot.component';

@NgModule({
  imports: [
    CommonModule,
    ForgotRoutingModule
  ],
  declarations: [ForgotComponent]
})
export class ForgotModule { }
