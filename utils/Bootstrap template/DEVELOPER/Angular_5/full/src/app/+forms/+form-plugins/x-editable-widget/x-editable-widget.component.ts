import {Component, OnInit, OnChanges, Input} from '@angular/core';

@Component({
  selector: 'x-editable-widget',
  templateUrl: './x-editable-widget.component.html',
})
export class XEditableWidgetComponent implements OnInit {

  public model:any = {
    username: 'superuser',
    firstname: null,
    sex: 'not selected',
    group: "Admin",
    vacation: "25.02.2013",
    combodate: "15/05/1984",
    event: null,
    comments: 'awesome user!',
    state2: 'California',
    fruits: 'peach,apple',
    dob: '1984-05-15'
  };


  public fruits = [
    {value: 'banana', text: 'banana'},
    {value: 'peach', text: 'peach'},
    {value: 'apple', text: 'apple'},
    {value: 'watermelon', text: 'watermelon'},
    {value: 'orange', text: 'orange'}
  ];

  public genders = [
    {value: 'not selected', text: 'not selected'},
    {value: 'Male', text: 'Male'},
    {value: 'Female', text: 'Female'}
  ];

  public groups = [
    {value: 'Guest', text: 'Guest'},
    {value: 'Service', text: 'Service'},
    {value: 'Customer', text: 'Customer'},
    {value: 'Operator', text: 'Operator'},
    {value: 'Support', text: 'Support'},
    {value: 'Admin', text: 'Admin'}
  ];

  @Input()  public options = {
    mode: 'inline',
    disabled: false,
    inline: true
  };


  constructor() {
  }

  ngOnInit() {
  }

  onChange(){
    this.options.mode = this.options.inline ? 'inline' : 'popup'
  }

}
