import {Component, OnInit} from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

//noinspection TypeScriptUnresolvedFunction
const $script = require('scriptjs');

@FadeInTop()
@Component({
  selector: 'app-ckeditor',
  templateUrl: './ckeditor.component.html',
})
export class CkeditorComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    $script("https://cdn.ckeditor.com/4.5.11/standard/ckeditor.js", ()=> {
      const CKEDITOR = window['CKEDITOR'];

      CKEDITOR.replace('ckeditor-showcase');
    });
  }

}
