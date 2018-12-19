import {Component, OnInit} from '@angular/core';

@Component({

  selector: 'sa-contact-form',
  templateUrl: './contact-form.component.html',
})
export class ContactFormComponent implements OnInit {

  validatorOptions = {
    container: '#messages',
    feedbackIcons: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      fullName: {
        validators: {
          notEmpty: {
            message: 'The full name is required and cannot be empty'
          }
        }
      },
      email: {
        validators: {
          notEmpty: {
            message: 'The email address is required and cannot be empty'
          },
          emailAddress: {
            message: 'The email address is not valid'
          }
        }
      },
      title: {
        validators: {
          notEmpty: {
            message: 'The title is required and cannot be empty'
          },
          stringLength: {
            max: 100,
            message: 'The title must be less than 100 characters long'
          }
        }
      },
      content: {
        validators: {
          notEmpty: {
            message: 'The content is required and cannot be empty'
          },
          stringLength: {
            max: 500,
            message: 'The content must be less than 500 characters long'
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
