import { Component, OnInit } from '@angular/core';

import {COUNTRIES} from '../../../shared/forms/common/countries'

@Component({

  selector: 'sa-checkout-form',
  templateUrl: './checkout-form.component.html'
})
export class CheckoutFormComponent implements OnInit {

  public countries: Array<any>

  public validationOptions = {
    rules : {
      fname : {
        required : true
      },
      lname : {
        required : true
      },
      email : {
        required : true,
        email : true
      },
      phone : {
        required : true
      },
      country : {
        required : true
      },
      city : {
        required : true
      },
      code : {
        required : true,
        digits : true
      },
      address : {
        required : true
      },
      name : {
        required : true
      },
      card : {
        required : true,
        creditcard : true
      },
      cvv : {
        required : true,
        digits : true
      },
      month : {
        required : true
      },
      year : {
        required : true,
        digits : true
      }
    },

    // Messages for form validation
    messages : {
      fname : {
        required : 'Please enter your first name'
      },
      lname : {
        required : 'Please enter your last name'
      },
      email : {
        required : 'Please enter your email address',
        email : 'Please enter a VALID email address'
      },
      phone : {
        required : 'Please enter your phone number'
      },
      country : {
        required : 'Please select your country'
      },
      city : {
        required : 'Please enter your city'
      },
      code : {
        required : 'Please enter code',
        digits : 'Digits only please'
      },
      address : {
        required : 'Please enter your full address'
      },
      name : {
        required : 'Please enter name on your card'
      },
      card : {
        required : 'Please enter your card number'
      },
      cvv : {
        required : 'Enter CVV2',
        digits : 'Digits only'
      },
      month : {
        required : 'Select month'
      },
      year : {
        required : 'Enter year',
        digits : 'Digits only please'
      }
    },
    submitHandler: this.onSubmit

  };

  constructor() {
  }

  ngOnInit() {
    this.countries = COUNTRIES
  }

  onSubmit(){
    console.log('\n', 'submit handler for validated form', '\n\n')
  }
}
