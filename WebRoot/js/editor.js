var editor;

function init() {
 editor = document.getElementById("storyEditField");
 //editor.onclick = handleButtonClick;
}
/*
function handleButtonClick() {
 //alert(editor.innerHTML);
}

function as(){
var value= event.keyCode;
   var key = String.fromCharCode(event.keyCode) ;
   alert(value);alert(key);
  document.onkeydown = keyDown;
}
*/
function uploadPicture(){
<<<<<<< HEAD
	var pictureUrl = prompt("online picture url:","");
	editor.innerHTML = editor.innerHTML+"<br>"
	+"<img src=\""+pictureUrl+"\" height=\"200px\"/>"+"<div></div>";
=======
	editor.innerHTML = editor.innerHTML+"<br>"
	+"<img src=\"http://www.baidu.com/img/bdlogo.png\" width=\"30px\" height=\"40px\"/>"+"<div></div>";
>>>>>>> origin/master

}

window.onload = init;