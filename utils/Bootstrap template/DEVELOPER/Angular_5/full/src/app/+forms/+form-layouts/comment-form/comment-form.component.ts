import {Component, OnInit} from '@angular/core';

@Component({

  selector: 'sa-comment-form',
  templateUrl: './comment-form.component.html',
})
export class CommentFormComponent implements OnInit {

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
      url: {
        url: true
      },
      comment: {
        required: true
      }
    },

    // Messages for form validation
    messages: {
      name: {
        required: 'Enter your name',
      },
      email: {
        required: 'Enter your email address',
        email: 'Enter a VALID email'
      },
      url: {
        email: 'Enter a VALID url'
      },
      comment: {
        required: 'Please enter your comment'
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
