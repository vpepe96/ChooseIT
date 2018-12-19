import {Component, OnInit, Input} from '@angular/core';


@Component({
  selector: 'message-labels',
  template: '<span *ngFor="let label of message.labels" class="label bg-color-{{LABELS[label].color}}">{{LABELS[label].name}}</span>',
})
export class MessageLabelsComponent implements OnInit {

  @Input() message:any;
  public LABELS = {
    home: {
      name: "HOME",
      color: "teal"
    },
    work: {
      name: "WORK",
      color: "orange"
    }
  };

  constructor() {
  }

  ngOnInit() {}

}
