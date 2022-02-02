function openForm() {
  document.getElementById("myForm").style.display = "block";
}


function addField(n)
{
    var tr = n.parentNode.parentNode.cloneNode(true);
    document.getElementById('RecipeTable').appendChild(tr);
}
