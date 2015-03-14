<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Welcome to Travel In Map</title>
<link rel="stylesheet" href="style/main.css">
<link rel="stylesheet" href="style/loginstyle.css">
<script src="js/signupValidate.js"></script>
</head>

<body style="background-color:rgb(222,222,222)">

<div id="header">
<form method="post" action="LogIn">
	<table>
    <tr valign="middle">
    <td><div><img src="image/logo.jpg" /></div></td>
    <td><input type="hidden" name="usertype" value="webUser" /></td>
	<td><input type="text" name="loginusername" id="loginusername" class="headertext" placeholder="username"/></td>
    <td><input type="password" name="loginpassword" id="loginpassword" class="headertext" placeholder="password"/></td>
    <td><input type="submit" class="headerbutton" value="Log In"/></td>
    </tr>
    </table>
</form>
</div><br>

<div id="signup">
<h1>Sign Up</h1>
<form method="post" action="SignUp">
    <input type="text" name="signupusername" id="signupusername" class="bodytext" placeholder="username" onBlur="validateUserName()"/><br>
    <input type="text" name="signupemail" id="signupemail" class="bodytext" placeholder="email address" onBlur="validateEmail()"/><br>
    <input type="password" name="signuppassword" id="signuppassword" class="bodytext" placeholder="password" onBlur="validatePassword()"/><br>
    <input type="password" name="signupreenterpassword" id="signupreenterpassword" class="bodytext"
    placeholder="re-enter your password" onBlur="validateReEnterPassword()"/><br>
    <input type="button" class="bodybutton" value="Sign Up" onclick="signupValidate(this.form)"/>
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
