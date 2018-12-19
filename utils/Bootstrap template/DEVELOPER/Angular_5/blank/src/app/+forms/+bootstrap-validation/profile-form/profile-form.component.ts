import {Component, OnInit} from '@angular/core';

@Component({

  selector: 'sa-profile-form',
  templateUrl: './profile-form.component.html',
})
export class ProfileFormComponent implements OnInit {

  validatorOptions = {
    feedbackIcons: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      email: {
        validators: {
          notEmpty: {
            message: 'The email address is required'
          },
          emailAddress: {
            message: 'The email address is not valid'
          }
        }
      },
      password: {
        validators: {
          notEmpty: {
            message: 'The password is required'
          }
        }
      }
    }
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
