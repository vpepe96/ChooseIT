import {Component, OnInit, OnDestroy} from '@angular/core';
import * as examples from "./flot-examples"
import {JsonApiService} from "../../core/api/json-api.service";
import {FakeDataSource} from "./flot-examples";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-flot-charts',
  templateUrl: './flot-charts.component.html',
})
export class FlotChartsComponent implements OnInit, OnDestroy {

  public flotData:any;
  public flotExamples:any;


  public updatingData: Array<any>;

  constructor(private jsonApiService:JsonApiService) {
  }

  ngOnInit() {
    this.jsonApiService.fetch( '/graphs/flot.json').subscribe(data => this.flotData = data);
    this.flotExamples = examples;

    this.interval = setInterval(()=>{
      this.updateStats()
    }, 1000);
    this.updateStats()
  }

  updateStats() {
    this.updatingData = [FakeDataSource.getRandomData()]
  }

  private interval;

  ngOnDestroy() {
    this.interval &&  clearInterval(this.interval);
  }

}
