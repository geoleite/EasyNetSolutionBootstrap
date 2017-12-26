console.log("rodei");
//var textnode = document.createTextNode("GM");         // Create a text node
//node.appendChild(textnode);                              // Append the text to <li>
//document.getElementById("body").appendChild(node); 
console.log("Verificando jquery ");
var versaoJquery = $.fn.jquery;
console.log('Versão jQuery: ' + versaoJquery);
if (versaoJquery != null) {
    var node = document.createElement("div");                 // Create a <li> node
    node.setAttribute("id", "loaded");
    document.getElementsByTagName("body")[0].appendChild(node);
}


