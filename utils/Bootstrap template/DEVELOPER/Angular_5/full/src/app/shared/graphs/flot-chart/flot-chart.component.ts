import {
  Component, OnInit, ElementRef, Input, AfterContentInit, OnChanges,
  SimpleChanges,
  DoCheck
} from '@angular/core';

declare var $: any;

@Component({

  selector: 'sa-flot-chart',
  template: `
    <div class="sa-flot-chart" [ngStyle]="{width: width, height: height}">&nbsp;</div>
  `,
  styles: [`
  :host{display:block;height:100%;width:100%}
  .sa-flot-chart{
    overflow: hidden;
  }
`]
})
export class FlotChartComponent implements AfterContentInit, OnChanges, DoCheck {

  @Input() public data:any;
  @Input() public graphClass: string= '';
  @Input() public options:any;
  @Input() public type:string;
  @Input() width:string = '100%';
  @Input() height:string = '250px';
  private hostVisible = false

  private vendorLoaded = false;

  constructor(private el: ElementRef) {}

  ngAfterContentInit() {
    System.import('imports-loader?this=>window!smartadmin-plugins/flot-bundle/flot-bundle.min.js').then(()=>{
      this.vendorLoaded = true;
      this.render(this.data)
    });
  }

  render(data){
    if(data && this.vendorLoaded && this.el.nativeElement.offsetParent!==null){
      $.plot(this.el.nativeElement.children[0], data, this.options)
    }
  }

  ngOnChanges(changes){
    if(changes.data.currentValue){
      this.render(changes.data.currentValue)
    }
  }

  ngDoCheck() {
    let visible = this.el.nativeElement.children[0].offsetParent!==null
    if(this.hostVisible != visible ){
      if(visible) this.render(this.data)
      this.hostVisible = visible
    }
  }
}
