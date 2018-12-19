import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'fuel-ux-wizard-widget',
  templateUrl: './fuel-ux-wizard-widget.component.html',
})
export class FuelUxWizardWidgetComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  onWizardComplete(data){
    console.log('fuel-ux wizard complete', data)
  }

}
