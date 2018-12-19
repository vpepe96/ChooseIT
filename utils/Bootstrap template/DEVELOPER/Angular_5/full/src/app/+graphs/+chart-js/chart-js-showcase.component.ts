import {Component, OnInit, OnDestroy} from '@angular/core';
import {JsonApiService} from "../../core/api/json-api.service";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-chart-js-showcase',
  templateUrl: './chart-js-showcase.component.html',
})
export class ChartJsShowcaseComponent implements OnInit, OnDestroy {

  public chartjsData: any;

  constructor(private jsonApiService: JsonApiService) {}

  ngOnInit() {
    this.jsonApiService.fetch( '/graphs/chartjs.json').subscribe((data)=>{
      this.chartjsData = data;
    })
  }

  ngOnDestroy(){}

}
