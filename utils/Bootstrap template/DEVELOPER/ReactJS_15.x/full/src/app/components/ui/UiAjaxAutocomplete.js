import React from 'react'

export default class UiAjaxAutocomplete extends React.Component {
  componentDidMount() {

    let self = this;


    function split(val) {
      return val.split(/,\s*/);
    }

    function extractLast(term) {
      return split(term).pop();
    }

    function extractFirst(term) {
      return split(term)[0];
    }

    let element = $(this.refs.input)

    element.autocomplete({
      source (request, response) {
        jQuery.getJSON(
          "http://gd.geobytes.com/AutoCompleteCity?callback=?&q=" + extractLast(request.term),
          function (data) {
            response(data);
          }
        );
      },
      minLength: 3,
      select (event, ui) {
        var selectedObj = ui.item,
          placeName = selectedObj.value;
        if (typeof placeName == "undefined") placeName = element.val();

        if (placeName) {
          var terms = split(element.val());
          // remove the current input
          terms.pop();
          // add the selected item (city only)
          terms.push(extractFirst(placeName));
          // add placeholder to get the comma-and-space at the end
          terms.push("");

          if (self.props.onFind)
            self.props.onFind(terms.join(", "))
        }

        return false;
      },
      focus () {
        // prevent value inserted on focus
        return false;
      },
      delay: 100
    });

  }

  render() {
    const { onFind, ...props} = {...this.props}

    return <input type="text" {...props} ref="input"/>
  }
}