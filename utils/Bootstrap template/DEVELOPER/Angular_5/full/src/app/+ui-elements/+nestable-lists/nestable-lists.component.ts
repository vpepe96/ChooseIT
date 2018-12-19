import { Component, OnInit } from '@angular/core';
import {JsonApiService} from "../../core/api/json-api.service";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-nestable-lists',
  templateUrl: './nestable-lists.component.html',

})
export class NestableListsComponent implements OnInit {

  public demo1: any;
  public nestable1DemoOutput: any;

  public demo2: any;
  public nestable2DemoOutput: any;

  public demo3: any;
  public nestable3DemoOutput: any;


  constructor(
    private jsonApiService:JsonApiService
  ) {

  }

  ngOnInit() {
    this.jsonApiService.fetch('/ui-examples/nestable-lists.json').subscribe(data=> {
      this.demo1 = data.demo1;
      this.demo2 = data.demo2;
      this.demo3 = data.demo2;
    })
  }

  public onChange1(payload){
    this.nestable1DemoOutput = payload
  }

  public onChange2(payload){
    this.nestable2DemoOutput = payload
  }

  public onChange3(payload){
    this.nestable1DemoOutput = payload
  }

}
