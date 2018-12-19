import React from 'react'

import BootstrapValidator from '../../../../components/forms/validation/BootstrapValidator'

const validatorOptions = {
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

export default class ProfileForm extends React.Component{
  onSubmit(e) {
    e.preventDefault();
    console.log('submit stuff')
  }
  render() {
    return (
      <BootstrapValidator options={validatorOptions}>
        <form id="profileForm" onSubmit={this.onSubmit}>

          <fieldset>
            <legend>
              Default Form Elements
            </legend>
            <div className="form-group">
              <label>Email address</label>
              <input type="text" className="form-control" name="email"/>
            </div>
          </fieldset>
          <fieldset>
            <div className="form-group">
              <label>Password</label>
              <input type="password" className="form-control" name="password"/>
            </div>
          </fieldset>

          <div className="form-actions">
            <div className="row">
              <div className="col-md-12">
                <button className="btn btn-default" type="submit">
                  <i className="fa fa-eye"/>
                  Validate
                </button>
              </div>
            </div>
          </div>
        </form>
      </BootstrapValidator>
    )
  }
}