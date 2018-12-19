import { Component, OnInit } from '@angular/core';
import {FadeInTop} from "../../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-topic-view',
  templateUrl: './topic-view.component.html',
})
export class TopicViewComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

}
