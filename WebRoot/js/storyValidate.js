function validatelocationLat(){
	var isValid = true;
	var locationLat = document.getElementById("locationLat");
	if(locationLat.value==""){isValid=false;}
	if(isNaN(locationLat.value)){isValid=false;}
	return isValid;
}
function validatelocationLng(){
	var isValid = true;
	var locationLng = document.getElementById("locationLng");
	if(locationLng.value==""){isValid=false;}
	if(isNaN(locationLng.value)){isValid=false;}
	return isValid;
}

function storyValidate(form){
	document.getElementById("convertedtitle").value=encodeURIComponent(document.getElementById("title").value);
	document.getElementById("converteddate").value=encodeURIComponent(document.getElementById("date").value);
	document.getElementById("convertedduration").value=encodeURIComponent(document.getElementById("duration").value);
	document.getElementById("convertedcontent").value=encodeURIComponent(document.getElementById("storyEditField").innerHTML);
	form.submit();
}