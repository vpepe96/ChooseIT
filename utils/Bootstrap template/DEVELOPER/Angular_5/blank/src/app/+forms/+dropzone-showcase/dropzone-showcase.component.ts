import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-dropzone-showcase',
  templateUrl: './dropzone-showcase.component.html',
})
export class DropzoneShowcaseComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
