"use strict";


angular.module('app.ui').controller('TreeviewCtrl', function ($scope) {
    $scope.demoTree1 = [
        {"content": "<span><i class=\"fa fa-lg fa-calendar\"></i> 2013, Week 2</span>", "expanded": true, "children": [
            {"content": "<span class=\"label label-success\"><i class=\"fa fa-lg fa-plus-circle\"></i> Monday, January 7: 8.00 hours</span>", "expanded": true, "children": [
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 8.00</span> &ndash; <a> Changed CSS to accomodate...</a>"}
            ]},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 8.00</span> &ndash; <a> Changed CSS to accomodate...</a>"},
            {"content": "<span class=\"label label-success\"><i class=\"fa fa-lg fa-minus-circle\"></i> Tuesday, January 8: 8.00 hours</span>", "expanded": true, "children": [
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 6.00</span> &ndash; <a> Altered code...</a>"},
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 2.00</span> &ndash; <a> Simplified our approach to...</a>"}
            ]},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 6.00</span> &ndash; <a> Altered code...</a>"},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 2.00</span> &ndash; <a> Simplified our approach to...</a>"},
            {"content": "<span class=\"label label-warning\"><i class=\"fa fa-lg fa-minus-circle\"></i> Wednesday, January 9: 6.00 hours</span>", "children": [
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 3.00</span> &ndash; <a> Fixed bug caused by...</a>"},
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 3.00</span> &ndash; <a> Comitting latest code to Git...</a>"}
            ]},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 3.00</span> &ndash; <a> Fixed bug caused by...</a>"},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 3.00</span> &ndash; <a> Comitting latest code to Git...</a>"},
            {"content": "<span class=\"label label-danger\"><i class=\"fa fa-lg fa-minus-circle\"></i> Wednesday, January 9: 4.00 hours</span>", "children": [
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 2.00</span> &ndash; <a> Create component that...</a>"}
            ]},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 2.00</span> &ndash; <a> Create component that...</a>"}
        ]},
        {"content": "<span><i class=\"fa fa-lg fa-calendar\"></i> 2013, Week 3</span>", "children": [
            {"content": "<span class=\"label label-success\"><i class=\"fa fa-lg fa-minus-circle\"></i> Monday, January 14: 8.00 hours</span>", "children": [
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 7.75</span> &ndash; <a> Writing documentation...</a>"},
                {"content": "<span><i class=\"fa fa-clock-o\"></i> 0.25</span> &ndash; <a> Reverting code back to...</a>"}
            ]},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 7.75</span> &ndash; <a> Writing documentation...</a>"},
            {"content": "<span><i class=\"fa fa-clock-o\"></i> 0.25</span> &ndash; <a> Reverting code back to...</a>"}
        ]}
    ]

    $scope.demoTree2 = [
        {"content": "<span><i class=\"fa fa-lg fa-folder-open\"></i> Parent</span>", "expanded": true, "children": [
            {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Administrators</span>", "expanded": true, "children": [
                {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" name=\"checkbox-inline\"><i></i>Michael.Jackson</label> </span>"},
                {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" checked=\"checked\" name=\"checkbox-inline\"><i></i>Sunny.Ahmed</label> </span>"},
                {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" checked=\"checked\" name=\"checkbox-inline\"><i></i>Jackie.Chan</label> </span>"}
            ]},
            {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" name=\"checkbox-inline\"><i></i>Michael.Jackson</label> </span>"},
            {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" checked=\"checked\" name=\"checkbox-inline\"><i></i>Sunny.Ahmed</label> </span>"},
            {"content": "<span> <label class=\"checkbox inline-block\"><input type=\"checkbox\" checked=\"checked\" name=\"checkbox-inline\"><i></i>Jackie.Chan</label> </span>"},
            {"content": "<span><i class=\"fa fa-lg fa-minus-circle\"></i> Child</span>", "expanded": true, "children": [
                {"content": "<span><i class=\"icon-leaf\"></i> Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Grand Child</span>"},
                {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Grand Child</span>",  "children": [
                    {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Great Grand Child</span>", "children": [
                        {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                        {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"}
                    ]},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"}
                ]},
                {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Great Grand Child</span>", "children": [
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"}
                ]},
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"}
            ]},
            {"content": "<span><i class=\"icon-leaf\"></i> Grand Child</span>"},
            {"content": "<span><i class=\"icon-leaf\"></i> Grand Child</span>"},
            {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Grand Child</span>", "children": [
                {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Great Grand Child</span>", "children": [
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                    {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"}
                ]},
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"}
            ]},
            {"content": "<span><i class=\"fa fa-lg fa-plus-circle\"></i> Great Grand Child</span>", "children": [
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
                {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"}
            ]},
            {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
            {"content": "<span><i class=\"icon-leaf\"></i> Great great Grand Child</span>"},
            {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"},
            {"content": "<span><i class=\"icon-leaf\"></i> Great Grand Child</span>"}
        ]},
        {"content": "<span><i class=\"fa fa-lg fa-folder-open\"></i> Parent2</span>", "children": [
            {"content": "<span><i class=\"icon-leaf\"></i> Child</span>"}
        ]}
    ]
});