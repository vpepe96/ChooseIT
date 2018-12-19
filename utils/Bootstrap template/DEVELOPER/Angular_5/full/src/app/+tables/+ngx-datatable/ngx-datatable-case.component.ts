import { Component, OnInit, ViewEncapsulation } from '@angular/core';

@Component({
  selector: 'ngx-datatable-case',
  templateUrl: './ngx-datatable-case.component.html',
  styleUrls: [
    
    // material theme from ngx-datatable teem
    // '../../../../node_modules/@swimlane/ngx-datatable/release/themes/material.css',
    // '../../../../node_modules/@swimlane/ngx-datatable/release/assets/icons.css',
    
    
    './smartadmin-ngx-datatable.css'
  ],

    encapsulation: ViewEncapsulation.None
})
export class NgxDatatableCaseComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
