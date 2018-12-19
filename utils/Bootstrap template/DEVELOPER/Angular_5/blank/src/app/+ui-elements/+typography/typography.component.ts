import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-typography',
  templateUrl: './typography.component.html',
  styleUrls: ['./typography.component.css'],

})
export class TypographyComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
