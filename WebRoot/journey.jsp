<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<<<<<<< HEAD
<%
if((UserBean)session.getAttribute("user")==null){
	response.sendRedirect("index.jsp");
	return;
}
UserBean user = (UserBean)session.getAttribute("user");
%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.*" %>
<% StoryBean story = (StoryBean)request.getAttribute("story"); %>
<% JourneyBean journey = (JourneyBean)request.getAttribute("journey"); %>
<% ArrayList<StoryBean> storyList = journey.getStoryList(); %>
=======
<%@ page import="java.util.ArrayList" %>
<% int storyID = (Integer)request.getAttribute("storyID"); %>
<% StoryBean story = (StoryBean)request.getAttribute("storyDetail"); %>
>>>>>>> origin/master
<% ArrayList<CommentBean> commentList = (ArrayList<CommentBean>)request.getAttribute("commentList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Story</title>
<link rel="stylesheet" href="style/main.css">
<link rel="stylesheet" href="style/storypresentation.css">
<script src="js/editor.js"></script>
<script src="http://maps.google.cn/maps/api/js?v=3.exp&sensor=true"></script>
<script src="js/journeymap.js"></script>
<script src="js/commentValidate.js"></script>
</head>

<body>
<<<<<<< HEAD
<table width="100%" border="0">
=======
<table width="100%" border="1">
>>>>>>> origin/master
<tr>
<td colspan="2">
<jsp:include page="header.jsp" flush="true" />
</td>
</tr>

<tr>
<<<<<<< HEAD
<td rowspan="6" width="auto" valign="top">
	<h3>In Journey "<% out.print(URLDecoder.decode(journey.getTitle(),"utf-8"));%>"</h3>
	<h3>There is <% out.print(storyList.size()); %> stories.</h3>
	<br>
	Journey Author:
	<img src="<% out.print(user.getHeadPicture()); %>" height="30px" width="30px" alt="Head Picure"/>
	<% out.print(user.getName()); %>
	<br>
    <ul id="storylist" style="ist-style-type:none">
    <%
    for (int i=0;i<storyList.size();i++){
    %>
    <li class='storylist'>
    <%
    out.print("<a href=\"Journey?storyId="+storyList.get(i).getId()+"\">");
    out.print("Day "+(i+1)+": ");
    out.print(URLDecoder.decode(storyList.get(i).getTitle(),"utf-8"));
    out.print("</a>");
    %>
    </li>
    <%
    }
    %>
    </ul>
</td>
<td width="1000">
	<div id="map-canvas"></div>
	<script>
	var currentstoryid = "<% out.print(story.getId()); %>";
	</script>
	<%
	
	for (int i=0; i<storyList.size(); i++){
	%>
	<script>
	var storyId = "<% out.print(storyList.get(i).getId()); %>";
	var storyTitle = "<% out.print(storyList.get(i).getTitle()); %>";
	var markLocation = new google.maps.LatLng(<% out.print(storyList.get(i).getLatitude()); %>, <% out.print(storyList.get(i).getLongitude()); %>);
	storyIds.push(storyId);
	storyTitles.push(storyTitle);
	locations.push(markLocation);
	</script>
	<%
	}
	%>
=======
<td rowspan="5" width="auto">
    <div id="storylist">story list will appear here</div>
</td>
<td width="1000">
	<div id="map-canvas"></div>
>>>>>>> origin/master
</td>
</tr>

<tr>
<td width="1000">
<<<<<<< HEAD
	<br><h3 id="storytitle">story title will appear here</h3>
=======
	<div id="storytitle">story title will appear here</div>
>>>>>>> origin/master
	<script>
	var title = "<% out.print(story.getTitle()); %>";
	title = decodeURIComponent(title);
	document.getElementById("storytitle").innerHTML = title;
	</script>
</td>
</tr>

<tr>
<td width="1000">
<<<<<<< HEAD
	<a id="storydate">Date: <% out.print(story.getDate()); %></a>
</td>
</tr>
<tr>
<td width="1000">
	Duration:
	<a id="storyduration">story duration will appear here</a>
	Hours
=======
	<em id="storydate">Date: <% out.print(story.getDate()); %></em>
	<em>Duration:</em>
	<em id="storyduration">story duration will appear here</em>
	<em>Hours</em>
>>>>>>> origin/master
	<script>
	var duration = "<% out.print(story.getDuration()); %>";
	duration = decodeURIComponent(duration);
	document.getElementById("storyduration").innerHTML = duration;
	</script>
</td>
</tr>

<tr>
<td width="1000" >
<<<<<<< HEAD
	<br><div id="storycontent" style="border: 1px solid;">story content will appear here</div><br>
=======
	<div id="storycontent">story content will appear here</div>
>>>>>>> origin/master
	<script>
	var content = "<% out.print(story.getContent()); %>";
	content = decodeURIComponent(content);
	document.getElementById("storycontent").innerHTML = content;
	</script>
</td>
</tr>

<tr>
<td width="1000">
	<div id="comment"></div>
<<<<<<< HEAD
	Comment:
	<table border="1">
		<tr>
		<td>providerName</td><td>ProviderPicture</td><td>content</td><td>time</td>
		
=======
	<table border="1">
		<tr>
		<td>providerName</td><td>ProviderPicture</td><td>content</td><td>time</td>
>>>>>>> origin/master
		</tr>
		<%
		for(int i=0; i<commentList.size(); i++){
			out.println("<tr>");
			out.println("<td>" + commentList.get(i).getProviderName() + "</td>");
			//String url = "<td><img src='"+commentList.get(i).getProviderPicture()+"' height='30px' width='30px' /></td>";
			out.println("<td><img src='"+commentList.get(i).getProviderPicture()+"' height='30px' width='30px' /></td>");
<<<<<<< HEAD
			out.println("<td name='commentContent' style='word-break:break-all;'>" + commentList.get(i).getContent() + "</td>");
=======
			out.println("<td name='commentContent'>" + commentList.get(i).getContent() + "</td>");
>>>>>>> origin/master
			out.println("<td>" + commentList.get(i).getTime() + "</td>");
			out.println("</tr>");
		}
		%>
	</table>
	<script>
	var commentContentList = document.getElementsByName("commentContent");
	var i;
	for(i=0;i<commentContentList.length;i++){
		commentContentList[i].innerHTML = decodeURIComponent(commentContentList[i].innerHTML);
	}
	</script>
<<<<<<< HEAD
	<br>
	<form method="post" action="AddComment">
		<input type="hidden" id="storyID" name="storyID" value="<% out.print(story.getId()); %>" />
		<input type="hidden" id="providerId" name="providerId" value="<% out.print(user.getId()); %>" />
=======
	<form method="post" action="AddComment">
		<input type="hidden" id="storyID" name="storyID" value="<% out.print(storyID); %>" />
		<input type="hidden" id="providerId" name="providerId" value="1" />
>>>>>>> origin/master
		<textarea rows="3" cols="50" id="commentContent" name="commentContent"></textarea>
		<input type="button" value="Add Comment" onClick="commentValidate(this.form)"/>
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
</html>