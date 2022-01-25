package com.recipeproject.recipeproject.models;
//
public class Form {

    private String form;

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }
}

//Form class is used to write the form's behavior into an object.
//Form controller is used to handle users' request and returns a response.  The flow of information.
//Form repository is used to




//  JS, Jquery, html, dom

//    function CreateRow(){
//        // Find a <table> element with id="myTable":
//        var table = document.getElementById("myTable");
//
//        // Create an empty <tr> element and add it to the 1st position of the table:
//        var row = table.insertRow();
//
//        // Insert new cells (<td> elements) at the 1st and 2nd position of the "new" <tr> element:
//        var cell1 = row.insertCell(0);
//        var cell2 = row.insertCell(1);
///**    $(cell2).bind('click', function() {
// CreateRow();
// });
// */
//        $(cell2).keydown(function (e){
//            if(e.keyCode == 13){
//                CreateRow();
//            }
//        });
//
//
//        // Add some text to the new cells:
//        cell1.innerHTML = "NEW CELL1";
//        cell2.innerHTML = "NEW CELL2";
//
//    }