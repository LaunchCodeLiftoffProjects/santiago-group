function openForm() {
  document.getElementById("myForm").style.display = "block";
}

function closeForm() {
  document.getElementById("myForm").style.display = "none";
}


function addField(n)
{
    var tr = n.parentNode.parentNode.cloneNode(true);
    document.getElementById('RecipeTable').appendChild(tr);
}

//function placeOrder(form){
//        form.submit();
//    }

function formSubmit()
{
    document.getElementById("myForm").submit();
}
