import {Component, OnInit} from '@angular/core';
import {JsonApiService} from "../../core/api/json-api.service";
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

@FadeInTop()
@Component({
  selector: 'sa-morris-charts',
  templateUrl: './morris-charts.component.html',
})
export class MorrisChartsComponent implements OnInit {

  public morrisDemoData:any;

  constructor(private jsonApiService:JsonApiService) {
  }

  ngOnInit() {
    this.jsonApiService.fetch( '/graphs/morris.json').subscribe(data => this.morrisDemoData = data)
  }

  barColorsDemo(row, series, type) {
    if (type === 'bar') {
      var red = Math.ceil(150 * row.y / 8);
      return 'rgb(' + red + ',0,0)';
    } else {
      return '#000';
    }
  }

  percentageFormat(x) {
    return x + "%"
  }

  dateFormat(d) {
    return (d.getMonth() + 1) + '/' + d.getDate() + '/' + d.getFullYear();
  }
}
