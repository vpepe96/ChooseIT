import React from 'react'

export default class UiDatepicker extends React.Component {
  componentDidMount() {
    const onSelectCallbacks = [];
    const props = this.props;
    const element = $(this.refs.input);

    if (props.minRestrict) {
      onSelectCallbacks.push((selectedDate) => {
        $(props.minRestrict).datepicker('option', 'minDate', selectedDate);
      });
    }
    if (props.maxRestrict) {
      onSelectCallbacks.push((selectedDate) => {
        $(props.maxRestrict).datepicker('option', 'maxDate', selectedDate);
      });
    }

    //Let others know about changes to the data field
    onSelectCallbacks.push((selectedDate) => {
      element.triggerHandler("change");

      const form = element.closest('form');

      if (typeof form.bootstrapValidator == 'function') {
        try {
          form.bootstrapValidator('revalidateField', element);
        } catch (e) {
          console.log(e.message)
        }
      }


    });

    const options = {
      prevText: '<i class="fa fa-chevron-left"></i>',
      nextText: '<i class="fa fa-chevron-right"></i>',
      onSelect: (selectedDate) => {
        onSelectCallbacks.forEach((cb)=> {
          cb.call(cb, selectedDate)
        })
      }
    };


    if (props.numberOfMonths) options.numberOfMonths = props.numberOfMonths;

    if (props.dateFormat) options.dateFormat = props.dateFormat;

    if (props.defaultDate) options.defaultDate = props.defaultDate;

    if (props.changeMonth) options.changeMonth = props.changeMonth;

    element.datepicker(options);
  }

  render() {
    const {
      minRestrict, maxRestrict, changesMonth,
      numberOfMonths, dateFormat, defaultDate, changeMonth,
      ...props
    } = {...this.props};
    return (
      <input type="text" {...props} ref="input"/>
    )
  }
}