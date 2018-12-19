import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'duallistbox-widget',
  templateUrl: './duallistbox-widget.component.html',
})
export class DuallistboxWidgetComponent implements OnInit {

  @Input() options = [{key: "option1", value:"Option 1"},
    {key: "option2", value:"Option 2"},
    {key: "option3", value:"Option 3"},
    {key: "option4", value:"Option 4"},
    {key: "option5", value:"Option 5"},
    {key: "option6", value:"Option 6"},
    {key: "option7", value:"Option 7"},
    {key: "option8", value:"Option 8", selected: true},
    {key: "option9", value:"Option 9", selected: true},
    {key: "option0", value:"Option 10"},
    {key: "option0", value:"Option 11"},
    {key: "option0", value:"Option 12"},
    {key: "option0", value:"Option 13"},
    {key: "option0", value:"Option 14"},
    {key: "option0", value:"Option 15"},
    {key: "option0", value:"Option 16"},
    {key: "option0", value:"Option 17"},
    {key: "option0", value:"Option 18"},
    {key: "option0", value:"Option 19"},
    {key: "option0", value:"Option 20"}];

  @Input() filter = 'ion ([7-9]|[1][0-2])';

  onChange($event){
    console.log('\n items', $event , '\n\n');
    console.log('\n options', this.options , '\n\n');
  }

  constructor() { }

  ngOnInit() {
  }

}
