import {Component, OnInit, Input} from '@angular/core';
import {JsonApiService} from "../../core/api/json-api.service";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-tree-views',
  templateUrl: './tree-views.component.html',

})
export class TreeViewsComponent implements OnInit {

  @Input() task:string
  @Input() week:string
  @Input() day:string

  public days = [
    'Monday',
    'Tuesday',
    'Wednesday',
    'Thursday',
    'Friday',
    'Saturday',
    'Sunday'];


  public demo1:any;
  public demo2:any;

  constructor(private jsonApiService:JsonApiService) {
  }

  add() {
    console.log(this.task, this.day)
  }

  ngOnInit() {
    this.jsonApiService.fetch('/ui-examples/tree-view.json').subscribe(data=> {
      this.demo1 = data.demo1;
      this.demo2 = data.demo2;
    })
  }

  changeLstener(payload) {
    console.log('change payload', payload)
  }


}
