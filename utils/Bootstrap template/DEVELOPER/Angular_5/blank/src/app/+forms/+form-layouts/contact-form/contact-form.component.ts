import {Component, OnInit} from '@angular/core';

@Component({

  selector: 'sa-contact-form',
  templateUrl: './contact-form.component.html',
})
export class ContactFormComponent implements OnInit {

  public validationOptions:any = {
    // Rules for form validation
    rules: {
      name: {
        required: true
      },
      email: {
        required: true,
        email: true
      },
      message: {
        required: true,
        minlength: 10
      }
    },

    // Messages for form validation
    messages: {
      name: {
        required: 'Please enter your name'
      },
      email: {
        required: 'Please enter your email address',
        email: 'Please enter a VALID email address'
      },
      message: {
        required: 'Please enter your message'
      }
    },

    submitHandler: this.onSubmit

  };

  constructor() {
  }

  ngOnInit() {
  }

  onSubmit(){
    console.log('\n', 'submit handler for validated form', '\n\n')
  }

}
