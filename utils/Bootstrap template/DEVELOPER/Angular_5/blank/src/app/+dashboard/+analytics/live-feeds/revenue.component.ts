import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'revenue-feed',
  templateUrl: './revenue.component.html',
  styles: []
})
export class RevenueComponent implements OnInit {

  @Input() public state = {
    targetsShow: true,
    actualsShow: true,
    signupsShow: true
  };

  public revenueData: Array<any>;

  constructor() {}

  ngOnInit() {
    this.updateData()
  }

  updateData() {
    let data = [];
    if (this.state.targetsShow) data.push(this.getTargetsData());
    if (this.state.actualsShow) data.push(this.getActualsData());
    if (this.state.signupsShow) data.push(this.getSignupsData());
    this.revenueData = data;
  }

  revenueChartOptions = {
    grid: {
      show: true,
      hoverable: true,
      clickable: true,
      borderWidth: 0
    },
    tooltip: true,
    tooltipOpts: {
      defaultTheme: false
    },
    xaxis: {
      mode: "time"
    },
    yaxes: {
      tickFormatter: function (val, axis) {
        return "$" + val;
      },
      max: 1200
    }
  };

  private getTargetsData() {
    return {
      label: "Target Profit",
      data: [[1354586000000, 153], [1364587000000, 658], [1374588000000, 198], [1384589000000, 663], [1394590000000, 801], [1404591000000, 1080], [1414592000000, 353], [1424593000000, 749], [1434594000000, 523], [1444595000000, 258], [1454596000000, 688], [1464597000000, 364]],
      bars: {
        show: true,
        align: "center",
        barWidth: 30 * 30 * 60 * 1000 * 80
      }
    }
  }

  private getActualsData() {
    return {
      label: "Actual Profit",
      data: [[1354586000000, 53], [1364587000000, 65], [1374588000000, 98], [1384589000000, 83], [1394590000000, 980], [1404591000000, 808], [1414592000000, 720], [1424593000000, 674], [1434594000000, 23], [1444595000000, 79], [1454596000000, 88], [1464597000000, 36]],
      color: '#3276B1',
      lines: {
        show: true,
        lineWidth: 3
      },
      points: {
        show: true
      }
    };
  }

  private getSignupsData() {
    return {
      label: "Actual Signups",
      data: [[1354586000000, 647], [1364587000000, 435], [1374588000000, 784], [1384589000000, 346], [1394590000000, 487], [1404591000000, 463], [1414592000000, 479], [1424593000000, 236], [1434594000000, 843], [1444595000000, 657], [1454596000000, 241], [1464597000000, 341]],
      color: '#71843F',
      lines: {
        show: true,
        lineWidth: 1
      },
      points: {
        show: true
      }
    }
  }

}
