import { Component, OnInit } from '@angular/core';

@Component({

  selector: 'sa-attribute-form',
  templateUrl: './attribute-form.component.html',
})
export class AttributeFormComponent implements OnInit {

  constructor() {}

  ngOnInit() {
  }

  submitted = false;
  onSubmit() {
    this.submitted = true;
    console.log('submitted')
  }

}
