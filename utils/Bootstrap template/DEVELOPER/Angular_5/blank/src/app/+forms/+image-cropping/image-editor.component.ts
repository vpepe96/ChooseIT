import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'app-image-editor',
  templateUrl: './image-editor.component.html',
})
export class ImageEditorComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
}
