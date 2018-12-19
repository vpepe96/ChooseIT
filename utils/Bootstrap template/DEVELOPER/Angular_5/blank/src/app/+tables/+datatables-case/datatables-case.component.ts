import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-datatables-case',
  templateUrl: './datatables-case.component.html',
})
export class DatatablesCaseComponent implements OnInit {

  constructor() {}

  ngOnInit() {    
  }

}
