<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<% int storyID = (Integer)request.getAttribute("storyID"); %>
<% StoryBean story = (StoryBean)request.getAttribute("storyDetail"); %>
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
<table width="100%" border="1">
<tr>
<td colspan="2">
<jsp:include page="header.jsp" flush="true" />
</td>
</tr>

<tr>
<td rowspan="5" width="auto">
    <div id="storylist">story list will appear here</div>
</td>
<td width="1000">
	<div id="map-canvas"></div>
</td>
</tr>

<tr>
<td width="1000">
	<div id="storytitle">story title will appear here</div>
	<script>
	var title = "<% out.print(story.getTitle()); %>";
	title = decodeURIComponent(title);
	document.getElementById("storytitle").innerHTML = title;
	</script>
</td>
</tr>

<tr>
<td width="1000">
	<em id="storydate">Date: <% out.print(story.getDate()); %></em>
	<em>Duration:</em>
	<em id="storyduration">story duration will appear here</em>
	<em>Hours</em>
	<script>
	var duration = "<% out.print(story.getDuration()); %>";
	duration = decodeURIComponent(duration);
	document.getElementById("storyduration").innerHTML = duration;
	</script>
</td>
</tr>

<tr>
<td width="1000" >
	<div id="storycontent">story content will appear here</div>
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
	<table border="1">
		<tr>
		<td>providerName</td><td>ProviderPicture</td><td>content</td><td>time</td>
		</tr>
		<%
		for(int i=0; i<commentList.size(); i++){
			out.println("<tr>");
			out.println("<td>" + commentList.get(i).getProviderName() + "</td>");
			//String url = "<td><img src='"+commentList.get(i).getProviderPicture()+"' height='30px' width='30px' /></td>";
			out.println("<td><img src='"+commentList.get(i).getProviderPicture()+"' height='30px' width='30px' /></td>");
			out.println("<td name='commentContent'>" + commentList.get(i).getContent() + "</td>");
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
	<form method="post" action="AddComment">
		<input type="hidden" id="storyID" name="storyID" value="<% out.print(storyID); %>" />
		<input type="hidden" id="providerId" name="providerId" value="1" />
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