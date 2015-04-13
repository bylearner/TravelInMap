<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<% StoryBean story;
try {
story = (StoryBean)request.getAttribute("story"); 
}
catch (Exception e) {return;}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Date: <% out.print(story.getDate()); %></div>
<br>
<div>Duration: <% out.print(story.getDuration()); %></div>
<br>
<div><% out.print(URLDecoder.decode(story.getContent(),"utf-8")); %></div>
</body>
</html>