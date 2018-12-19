import {Component, OnInit, Input} from '@angular/core';

import {NgRedux, select} from '@angular-redux/store'

@Component({
  selector: 'image-editor-default-panel',
  template: `
            <section>
                <jcrop
                    [storeId]="storeId" 
                    src="assets/img/superbox/superbox-full-11.jpg"
                    [width]="600" [height]="400"></jcrop>
            </section>
`,
})
export class DefaultPanelComponent implements OnInit {


  public storeId = 'defaultPanel';

  @Input() active: boolean;

  constructor(private ngRedux: NgRedux<any>) {

  }

  ngOnInit() {

  }


}
