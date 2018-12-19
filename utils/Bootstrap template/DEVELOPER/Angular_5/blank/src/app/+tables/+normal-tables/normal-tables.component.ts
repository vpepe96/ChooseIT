import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-normal-tables',
  templateUrl: './normal-tables.component.html',

})
export class NormalTablesComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
