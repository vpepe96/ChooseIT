import {Component, OnInit, Input, OnDestroy, NgZone} from '@angular/core';
import {FakeDataSource} from "../../../+graphs/+flot-charts/flot-examples";

@Component({
  selector: 'live-stats-feed',
  templateUrl: './live-stats.component.html',
  styles: []
})
export class LiveStatsComponent implements OnInit, OnDestroy {

  constructor(private zone: NgZone) {
  }

  ngOnInit() {
    this.updateStats()
  }

  @Input() public liveSwitch = false;


  public liveStats: Array<any>;


  updateStats() {
    this.liveStats = [FakeDataSource.getRandomData()]
  }

  private interval;

  toggleSwitch() {

    if (this.liveSwitch) {
      this.interval = setInterval(()=>{
        this.updateStats()
      }, 1000)
    } else {
      clearInterval(this.interval);
    }
  }

  ngOnDestroy() {
    this.interval &&  clearInterval(this.interval);
  }


  liveStatsChartOptions = {
    yaxis: {
      min: 0,
      max: 100
    },
    xaxis: {
      min: 0,
      max: 100
    },
    colors: ['rgb(87, 136, 156)'],
    grid: {
      show: true,
      hoverable: true,
      clickable: true,
      borderWidth: 0,
    },
    series: {
      lines: {
        lineWidth: 1,
        fill: true,
        fillColor: {
          colors: [
            {
              opacity: 0.4
            },
            {
              opacity: 0
            }
          ]
        },
        steps: false

      }
    }
  }


}



