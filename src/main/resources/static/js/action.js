function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}

var i = $('table tr').length;

$(document).on('keyup', '.lst', function(e) {
  var code = (e.keyCode ? e.keyCode : e.which);
   alert("Sup")
  if (code == 13) {
    html = '<tr>';
    html += '<td>' + i + '</td>';
    html += '<td><input type="text" class="form-popup" name="number_' + i + '" id="myForm_' + i + '" /></td>';
    html += '<td><input type="text" class="form-popup" name="measurement_' + i + '" id="myForm_' + i + '" /></td>';
    html += '<td><input type="text" class="form-popup" name="food_' + i + '" id="myForm_' + i + '" /></td>';
    html += '<td><input type="text" class="form-popup" name="prepNotes_' + i + '" id="myForm_' + i + '" /></td>';
    html += '</tr>';
    $('myForm').append(html);
    $(this).focus().select();
    i++;
  }
});

$(document).on('keydown', '.inputs', function(e) {
  var code = (e.keyCode ? e.keyCode : e.which);
  if (code == 13) {
    var index = $('.inputs').index(this) + 1;
    $('.inputs').eq(index).focus();
  }
});


document.getElementById("RecipeTable").addEventListener("keyup", function (e) {
e.preventDefault();
if (e.keyCode === 13) {
     var table = document.getElementById("RecipeTable");
      var row = table.insertRow(-1);
      var cell1 = row.insertCell(0);
      var cell2 = row.insertCell(1);
      var cell3 = row.insertCell(2);
      var cell4 = row.insertCell(3);
      cell1.innerHTML = '<input type="text" class="form-popup" name="number_" id="myForm_" />';
      cell2.innerHTML = '<input type="text" class="form-popup" name="measurement_" id="myForm_" />';
      cell3.innerHTML = '<input type="text" class="form-popup" name="food_" id="myForm_" />';
      cell4.innerHTML = '<input type="text" class="form-popup" name="prepNotes_" id="myForm_" />';

        }
    })


//<!DOCTYPE html>
//<html>
//<head>
//<style>
//table, td {
//  border: 1px solid black;
//}
//</style>
//</head>
//<body>
//
//<p>Click the button to add a new row at the first position of the table and then add cells and content.</p>
//
//<table id="myTable">
//  <tr>
//    <td>Row1 cell1</td>
//    <td>Row1 cell2</td>
//  </tr>
//  <tr>
//    <td>Row2 cell1</td>
//    <td>Row2 cell2</td>
//  </tr>
//  <tr>
//    <td>Row3 cell1</td>
//    <td>Row3 cell2</td>
//  </tr>
//</table>
//<br>
//
//<button type="button" onclick="myFunction()">Try it</button>
//
//<script>
//function myFunction() {
//  var table = document.getElementById("RecipeTable");
//  var row = table.insertRow(-1);
//  var cell1 = row.insertCell(0);
//  var cell2 = row.insertCell(1);
//  cell1.innerHTML = "NEW CELL1";
//  cell2.innerHTML = "NEW CELL2";
//}
//</script>
//
//</body>
//</html>
//
// html += '<input type="text" class="form-popup" name="number_" id="myForm_" />';
// html += '<input type="text" class="form-popup" name="number_" id="myForm_" />';
// html += '<input type="text" class="form-popup" name="number_" id="myForm_" />';
// html += '<input type="text" class="form-popup" name="number_" id="myForm_" />';
