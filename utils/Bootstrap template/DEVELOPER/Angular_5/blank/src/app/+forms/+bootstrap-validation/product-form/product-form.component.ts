import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'sa-product-form',
  templateUrl: './product-form.component.html',
})
export class ProductFormComponent implements OnInit {

  validatorOptions = {
    feedbackIcons: {
      valid: 'glyphicon glyphicon-ok',
      invalid: 'glyphicon glyphicon-remove',
      validating: 'glyphicon glyphicon-refresh'
    },
    fields: {
      price: {
        validators: {
          notEmpty: {
            message: 'The price is required'
          },
          numeric: {
            message: 'The price must be a number'
          }
        }
      },
      amount: {
        validators: {
          notEmpty: {
            message: 'The amount is required'
          },
          numeric: {
            message: 'The amount must be a number'
          }
        }
      },
      color: {
        validators: {
          notEmpty: {
            message: 'The color is required'
          }
        }
      },
      size: {
        validators: {
          notEmpty: {
            message: 'The size is required'
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
