<<<<<<< HEAD
<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<%
if((UserBean)session.getAttribute("user")==null){
	response.sendRedirect("index.jsp");
	return;
}
%>
=======
>>>>>>> origin/master
<%
String searchText = (String)request.getParameter("searchText");
if(searchText==null){searchText = "Beijing";}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Map Navigator</title>
<link rel="stylesheet" href="style/main.css">
<link rel="stylesheet" href="style/navigatorstyle.css">
<script src="http://maps.google.cn/maps/api/js?v=3.exp&sensor=true"></script>
<script src="js/navigatorgooglemap.js"></script>
</head>

<body>
<table width="100%" border="0">
<tr>
<td colspan="2">
<jsp:include page="header.jsp" flush="true" />
</td>
</tr>

<tr>
<td width="auto">
    <div id="map-canvas"></div>
</td>
<script>
	var searchText = "<% out.print(searchText); %>";
</script>

<td width="382">
<div id="sidebar">
<<<<<<< HEAD
    <div style="text-align:center;font-size: 30px;color: rgb(58,87,149)">Stories near you</div>
=======
    storylist<br>
>>>>>>> origin/master
    <div id="storylist">story link will appear here</div>
</div>
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