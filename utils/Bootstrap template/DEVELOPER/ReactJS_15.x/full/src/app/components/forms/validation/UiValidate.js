import React from 'react'
import _ from 'lodash'

import 'script-loader!jquery-validation'

import {findDOMNode} from 'react-dom';


export default class UiValidate extends React.Component {

  componentDidMount() {
    let form = $(findDOMNode(this))
    let validateCommonOptions = {
      rules: {},
      messages: {},
      errorElement: 'em',
      errorClass: 'invalid',
      highlight: (element, errorClass, validClass) => {
        $(element).addClass(errorClass).removeClass(validClass);
        $(element).parent().addClass('state-error').removeClass('state-success');
      },
      unhighlight: (element, errorClass, validClass) => {
        $(element).removeClass(errorClass).addClass(validClass);
        $(element).parent().removeClass('state-error').addClass('state-success');
      },

      errorPlacement: (error, element) =>{
        if (element.parent('.input-group').length) {
          error.insertAfter(element.parent());
        } else {
          error.insertAfter(element);
        }
      }
    }

    form.find('[data-smart-validate-input], [smart-validate-input]').each(function () {
      var $input = $(this), fieldName = $input.attr('name');

      validateCommonOptions.rules[fieldName] = {};

      if ($input.data('required') != undefined) {
        validateCommonOptions.rules[fieldName].required = true;
      }
      if ($input.data('email') != undefined) {
        validateCommonOptions.rules[fieldName].email = true;
      }

      if ($input.data('maxlength') != undefined) {
        validateCommonOptions.rules[fieldName].maxlength = $input.data('maxlength');
      }

      if ($input.data('minlength') != undefined) {
        validateCommonOptions.rules[fieldName].minlength = $input.data('minlength');
      }

      if ($input.data('message')) {
        validateCommonOptions.messages[fieldName] = $input.data('message');
      } else {
        _.forEach($input.data(), (value, key) => {
          if (key.search(/message/) == 0) {
            if (!validateCommonOptions.messages[fieldName])
              validateCommonOptions.messages[fieldName] = {};

            var messageKey = key.toLowerCase().replace(/^message/, '')
            validateCommonOptions.messages[fieldName][messageKey] = value;
          }
        });
      }
    });

    form.validate(_.extend(validateCommonOptions, this.props.options))
  }

  render() {
    return (
      this.props.children
    )
  }
}