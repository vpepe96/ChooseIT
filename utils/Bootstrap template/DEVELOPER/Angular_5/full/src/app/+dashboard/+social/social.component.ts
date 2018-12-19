import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-social',
  templateUrl: './social.component.html',
})
export class SocialComponent implements OnInit {

  ngOnInit() {
  }

}
