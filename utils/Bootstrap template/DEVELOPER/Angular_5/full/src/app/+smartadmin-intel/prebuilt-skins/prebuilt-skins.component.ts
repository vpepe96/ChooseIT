import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-prebuilt-skins',
  templateUrl: './prebuilt-skins.component.html',
})
export class PrebuiltSkinsComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
