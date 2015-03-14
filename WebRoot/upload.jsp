<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Story Upload</title>
<link rel="stylesheet" href="style/main.css">
<link rel="stylesheet" href="style/storypresentation.css">
<script src="js/editor.js"></script>
<script src="http://maps.google.cn/maps/api/js?v=3.exp&sensor=true"></script>
<script src="js/selectlocationmap.js"></script>
<script src="js/storyValidate.js"></script>
</head>

<body>

<table width="100%" border="1">
<tr>
<td colspan="2">
<jsp:include page="header.jsp" flush="true" />
</td>
</tr>

<tr>
<td width="auto" align="right">
    <div>Step One: Select Location</div>
    
</td>
<td width="1000">
	<div id="map-canvas"></div>
</td>
</tr>

<tr>
<td width="auto" align="right">
    <div>Step Two: Story Title</div>
</td>
<td width="1000">
	<input type="text" id="title" name="title" class="longbodytext"/>
</td>
</tr>

<tr>
<td width="auto" align="right">
    <div>Step Three: Story Date</div>
</td>
<td width="1000">
	<input type="date" id="date" name="date" class="bodytext"/>
</td>
</tr>

<tr>
<td width="auto" align="right">
    <div>Step Four: Story Duration</div>
</td>
<td width="1000">
	<input type="text" id="duration" name="duration" class="bodytext"/>Hours
</td>
</tr>

<tr>
<td width="auto" align="right";>
    <div>Step Five: Story Content</div>
</td>
<td width="1000" >
	<input type="button" value="insert picture" onClick="uploadPicture()"/>
	<input type="file" name="pic"/>
	<div id="storyEditField" contenteditable="true" style="background-color:rgb(222,222,222)"><br><br><br><br><br></div>
	
</td>
</tr>

<tr>
<td width="auto" align="right">
    <div>Step Six: Upload Your Story</div>
</td>
<td width="1000">
	<form method="post" action="AddStory">
	<input type="hidden" id="locationLat" name="locationLat"/>
    <input type="hidden" id="locationLng" name="locationLng"/>
    <input type="hidden" id="convertedtitle" name="convertedtitle"/>
    <input type="hidden" id="converteddate" name="converteddate"/>
    <input type="hidden" id="convertedduration" name="convertedduration"/>
    <input type="hidden" id="convertedcontent" name="convertedcontent"/>
	<input type="button" value="Upload" class="bodybutton" onClick="storyValidate(this.form)"/>
	</form>
</td>
</tr>

<tr>
<td colspan="2">
<div id="footer">
    Junyi Zou Final Year Project: QPF7 Contact: junyi.zou@se11.qmul.ac.uk
</div>
</td>
</tr>

</table>

</body>
</html>"