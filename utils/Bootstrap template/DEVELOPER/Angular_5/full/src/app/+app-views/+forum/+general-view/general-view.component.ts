import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-general-view',
  templateUrl: './general-view.component.html',
})
export class GeneralViewComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
