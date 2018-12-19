import React from 'react'
import _ from 'lodash'

import 'script-loader!fuelux/js/wizard.js'

export default class FuelUxWizard extends React.Component {
  componentDidMount() {
    let self = this;
    let element = $(this.refs.wizard);
    let wizard = element.wizard();

    let $form = element.find('form');

    wizard.on('actionclicked.fu.wizard', function (e, data) {
      if ($form.data('validator')) {
        if (!$form.valid()) {
          $form.data('validator').focusInvalid();
          e.preventDefault();
        }
      }
    });

    wizard.on('finished.fu.wizard', function (e, data) {
      var formData = {};
      _.each($form.serializeArray(), function (field) {
        formData[field.name] = field.value
      });
      if (_.isFunction(self.props.onComplete)) {
        self.props.onComplete(formData)
      }
    });
  }

  render() {
    let {children, onComplete, ...props} = this.props;
    return (
      <div {...props} ref="wizard">
        {children}
      </div>
    )
  }
}