import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { wizardsRouting } from './wizards.routing';
import {WizardsComponent} from "./wizards.component";
import {SmartadminModule} from "../../shared/smartadmin.module";
import {SmartadminWizardsModule} from "../../shared/forms/wizards/smartadmin-wizards.module";
import {BasicWizardWidgetComponent} from "./basic-wizard-widget/basic-wizard-widget.component";
import {FuelUxWizardWidgetComponent} from "./fuel-ux-wizard-widget/fuel-ux-wizard-widget.component";

@NgModule({
  imports: [
    CommonModule,
    wizardsRouting,
    SmartadminModule,
    SmartadminWizardsModule
  ],
  declarations: [WizardsComponent, BasicWizardWidgetComponent, FuelUxWizardWidgetComponent]
})
export class WizardsModule { }
