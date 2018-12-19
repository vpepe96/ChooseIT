import {Component, OnInit} from '@angular/core';
import {FadeInTop} from "../../shared/animations/fade-in-top.decorator";

declare var $: any;

@FadeInTop()
@Component({
  selector: 'sa-jquery-ui',
  templateUrl: './jquery-ui.component.html',
})
export class JqueryUiComponent implements OnInit {

  public demoAutocompleteWords = [
    "ActionScript",
    "AppleScript",
    "Asp",
    "BASIC",
    "C",
    "C++",
    "Clojure",
    "COBOL",
    "ColdFusion",
    "Erlang",
    "Fortran",
    "Groovy",
    "Haskell",
    "Java",
    "JavaScript",
    "Lisp",
    "Perl",
    "PHP",
    "Python",
    "Ruby",
    "Scala",
    "Scheme"];


  ajaxAutocompleteOptions = {
    source: (request, response) => {
      jQuery.ajax({
        url: "https://jqueryui.com/resources/demos/autocomplete/search.php",
        dataType: "jsonp",
        data: {
          term: request.term
        },
        success: (data) => {
          response(data);
        }
      });
    },
    minLength: 2,
    select: (event, ui) => {
      console.log("Selected: " + ui.item.value + " aka " + ui.item.id);
      this.ajaxAutocompleteSelected = ui.item.id
    }
  };

  ajaxAutocompleteSelected: string;


  constructor() {
  }

  ngOnInit() {
  }

  simpleDialogOptions = {
    autoOpen : false,
    width : 600,
    resizable : false,
    modal : true,
    closeText: '',
    title : "<div class='widget-header'><h4><i class='fa fa-warning'></i> Empty the recycle bin?</h4></div>",
    buttons : [{
      html : "<i class='fa fa-trash-o'></i>&nbsp; Delete all items",
      "class" : "btn btn-danger",
      click : function() {
        $(this).dialog("close");
      }
    }, {
      html : "<i class='fa fa-times'></i>&nbsp; Cancel",
      "class" : "btn btn-default",
      click : function() {
        $(this).dialog("close");
      }
    }]
  };

  messageDialogOptions = {
    autoOpen : false,
    modal : true,
    closeText: '',
    title : "<div class='widget-header'><h4><i class='icon-ok'></i> jQuery UI Dialog</h4></div>",
    buttons : [{
      html : "Cancel",
      "class" : "btn btn-default",
      click : function() {
        $(this).dialog("close");
      }
    }, {
      html : "<i class='fa fa-check'></i>&nbsp; OK",
      "class" : "btn btn-primary",
      click : function() {
        $(this).dialog("close");
      }
    }]

  };


}
