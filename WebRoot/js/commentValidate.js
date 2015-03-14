function validateCommentContent(){
	var isValid = true;
	var commentContent = document.getElementById("commentContent");
	if(commentContent.value==""){isValid=false;}
	return isValid;
}
function commentValidate(form){
	if(validateCommentContent()){
		document.getElementById("commentContent").value=encodeURIComponent(document.getElementById("commentContent").value);
		form.submit();
	}
}