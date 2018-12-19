import {Component, OnInit} from '@angular/core';

@Component({

  selector: 'sa-button-group-form',
  templateUrl: './button-group-form.component.html',
})
export class ButtonGroupFormComponent implements OnInit {

  validatorOptions = {
    excluded: ':disabled',
    feedbackIcons: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      gender: {
        validators: {
          notEmpty: {
            message: 'The gender is required'
          }
        }
      },
      'languages': {
        validators: {
          choice: {
            min: 1,
            max: 2,
            message: 'Please choose 1 - 2 languages you can speak'
          }
        }
      }
    }
  };


  model = {
    languages: [
      {key: 'english', value: 'English', selected: false},
      {key: 'german', value: 'German', selected: false},
      {key: 'french', value: 'French', selected: false},
      {key: 'russian', value: 'Russian', selected: false},
      {key: 'italian', value: 'Italian', selected: false}
    ],
    gender: undefined
  };

  constructor() {
  }

  ngOnInit() {
  }

  submitted = false;

  onSubmit() {
    this.submitted = true;
    console.log('submitted')
  }
}
