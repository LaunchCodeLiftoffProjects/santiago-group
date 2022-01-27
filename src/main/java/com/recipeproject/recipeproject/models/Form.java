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

// Do the following in order:
// Exit button will be with info used to do form pop up (login screen in W3 schools).
// Check out form handler in W3 schools for info on submitting form data.
// Add row with Enter key requires more reading from Kevin resources and own research.
// Start getting form css design set up.


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



//<html>
//<script>
//        function addRow() {
//                var table = document.getElementById('myTable');
//                //var row = document.getElementById("myTable");
//                var x = table.insertRow(0);
//                var e = table.rows.length-1;
//                var l = table.rows[e].cells.length;
//                //x.innerHTML = "&nbsp;";
//
//                for (var c=0, m=l; c < m; c++) {
//        table.rows[0].insertCell(c);
//        table.rows[0].cells[c].innerHTML = "&nbsp;&nbsp;";
//        }
//        }
//</script>
//
//<body>
//<input type="button" value="row +" onClick="addRow()" border=0 style='cursor:hand'>
//<input type="button" value="row -" onClick='deleteRow()' border=0 style='cursor:hand'>
//<input type="button" value="column +" onClick="addColumn()" border=0 style='cursor:hand'>
//<input type="button" value="column -" onClick='deleteColumn()' border=0 style='cursor:hand'>
//
//<table  id='myTable' border=1 cellpadding=0 cellspacing=0>
//<tr id='myRow'>
//<td>&nbsp;</td>
//<td>&nbsp;</td>
//<td>&nbsp;</td>
//</tr>
//<tr>
//<td>&nbsp;</td>
//<td>&nbsp;</td>
//<td>&nbsp;</td>
//</tr>
//</table>
//</body>
//</html>