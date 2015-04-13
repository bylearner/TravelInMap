<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<%
UserBean user = (UserBean)session.getAttribute("user");
if(user==null){
	response.sendRedirect("index.jsp");
	return;
}
%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.*" %>
<% ArrayList<JourneyBean> journeyList = (ArrayList<JourneyBean>) request.getAttribute("journeyList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Story</title>
<link rel="stylesheet" href="style/main.css">
</head>

<body>
<table width="100%">
<tr>
<td colspan="2">
<jsp:include page="header.jsp" flush="true" />
</td>
</tr>

<table border="1">
<br><br>
<%
for(int i=0; i<journeyList.size(); i++){
ArrayList<StoryBean> storyList = journeyList.get(i).getStoryList();
%>
<tr>
<td rowspan="<% out.print(storyList.size()+1); %>">
<% out.print(URLDecoder.decode(journeyList.get(i).getTitle(),"utf-8")); %>
</td>

<%
for(int j=0; j<storyList.size(); j++){
if(j>0){out.print("<tr>");}
%>
<td>
<%
out.print("<a href=\"Journey?storyId="+storyList.get(j).getId()+"\">");
out.print(URLDecoder.decode(storyList.get(j).getTitle(),"utf-8"));
out.print("</a>");
 %>
</td>
<td>
<a href="Edit?storyId=<% out.print(storyList.get(j).getId()); %>"><button class="smallbodybutton">Edit</button></a>
</td>
<td>
<a href="DeleteStory?storyId=<% out.print(storyList.get(j).getId()); %>"><button class="smallbodybutton">Delete</button></a>
</td>
</tr>
<%
}
%>
<%if(storyList.size()>0){out.print("<tr>");}%>
<td colspan="3"><a href="NewStory?journeyId=<% out.print(journeyList.get(i).getId()); %>">Add New Story to This Journey</a></td>
<%if(storyList.size()>0){out.print("<tr>");}%>
<%
}
%>
</table>
<br><br>
<form method="post" action="AddJourney">
<input type="text" id="journeyname" name="journeyname" class="longbodytext" placeholder="New Journey Title"/><br><br>
<input type="hidden" id="providerid" name="providerid" value="<% out.print(user.getId()); %>"/>
<input type="button" value="Add New Journey" class="bodybutton" onClick="JourneyValidate(this.form)"/>
</form>
<br><br>
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