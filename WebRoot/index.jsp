<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to Travel In Map</title>
<link rel="stylesheet" href="style/main.css">
<link rel="stylesheet" href="style/loginstyle.css">
<script src="js/validate.js"></script>
</head>

<body>

<div id="header">
<form method="post" action="LogIn">
    <a style="font-size:50px">TravelInMap</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp
    <input type="text" name="loginusername" id="loginusername" class="logintext" placeholder="username"/>
    <input type="password" name="loginpassword" id="loginpassword" class="logintext" placeholder="password"/>
    <input type="submit" class="loginbutton" value="Log In"/>
</form>
</div><br>

<div id="signup">
<h1>Sign Up</h1>
<form method="post" action="SignUp">
    <input type="text" name="signupusername" id="signupusername" class="signuptext" placeholder="username" onBlur="validateUserName()"/><br>
    <input type="text" name="signupemail" id="signupemail" class="signuptext" placeholder="email address" onBlur="validateEmail()"/><br>
    <input type="password" name="signuppassword" id="signuppassword" class="signuptext" placeholder="password" onBlur="validatePassword()"/><br>
    <input type="password" name="signupreenterpassword" id="signupreenterpassword" class="signuptext"
    placeholder="re-enter your password" onBlur="validateReEnterPassword()"/><br>
    <input type="radio" name="signupgender" id="signupfemale" value="female"><em>female</em>&nbsp;&nbsp;&nbsp;
    <input type="radio" name="signupgender" id="signupmale" value="male"><em>male</em><br>
    <input type="submit" class="signupbutton" value="Sign Up"/>&nbsp;&nbsp;
</form>
</div>

<div id="welcome">
<h1>Welcome To travelinmap.info</h1>
<div style="float:left">
<img src="image/googlemapstrademark.png" alt="google maps trademark" height="300px" width="300px"/>
</div>
<div style="font-size:18px">
<br><br><br>
<h3>you can:</h3>
<ul>
<li>search other people's travel story</li><br>
<li>upload your own travel story</li><br>
<li>share your travel story with your friends on facebook</li>
</ul>
</div>
</div>

<div id="footer">
Junyi Zou Final Year Project: QPF7 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Contact:&nbsp;&nbsp; junyi.zou@se11.qmul.ac.uk
</div>

</body>
</html>
