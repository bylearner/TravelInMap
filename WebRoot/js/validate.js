function validateUserName(){
	var isValid = true;
	var username = document.getElementById("signupusername");
	if(username.value==""){isValid=false;}
	if(isValid==false){username.style.borderColor = "#FF0000";alert("User name can't be empty!");}
	else {username.style.borderColor = "#FFFFFF";}
	return isValid;
}
function validateEmail(){
	var isValid = true;
	var email = document.getElementById("signupemail");
	if(email.value==""){isValid=false;}
	if(isValid==false){email.style.borderColor = "#FF0000";alert("Email address can't be empty!");}
	else {email.style.borderColor = "#FFFFFF";}
	return isValid;
}
function validatePassword(){
	var isValid = true;
	var password = document.getElementById("signuppassword");
	if(password.value==""){isValid=false;}
	if(isValid==false){password.style.borderColor = "#FF0000";alert("Password can't be empty!");}
	else {password.style.borderColor = "#FFFFFF";}
	return isValid;
}
function validateReEnterPassword(){
	var isValid = false;
	var password = document.getElementById("signuppassword");
	var reenterpassword = document.getElementById("signupreenterpassword");
	if(password.value==reenterpassword.value){isValid=true;}
	if(isValid==false){reenterpassword.style.borderColor = "#FF0000";alert("Password type error!");}
	else {reenterpassword.style.borderColor = "#FFFFFF";}
	return isValid;
}
function validateGender(){
}