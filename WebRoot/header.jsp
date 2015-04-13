<<<<<<< HEAD
<%@ page language="java" import="JavaBean.*" pageEncoding="UTF-8"%>
<% UserBean user = (UserBean)session.getAttribute("user");%>

=======
>>>>>>> origin/master
<div id="header">
    <table>
    <tr valign="middle">
    <td><div><a href="navigator.jsp"><img src="image/logo.jpg" /></a></div></td>
	<td>
	<form method="get" action="navigator.jsp">
	<input type="text" class="longheadertext" name="searchText" id="searchText"/>
    <input type="submit" class="headerbutton" id="search" value="Search"/>
	</form>
	</td>
<<<<<<< HEAD
    <td><a href="YourJourneyList"><button class="headerbutton">upload</button></a></td>   
    <td>&nbsp;&nbsp;<% out.print(user.getName()); %></td>
    <td><a href="http://www.baidu.com"><img src="<% out.print(user.getHeadPicture()); %>" height="30px" width="30px" alt="Head Picure"/></a></td>
    <td>&nbsp;&nbsp;<a href="SignOut"><img src="image/signout.jpg" alt="Head Picure"/></a></td>
    </tr>
    </table>
</div>

=======
    <td><a href="upload.jsp"><button class="headerbutton">upload</button></a></td>
    <td>Junyi Zou</td>
    <td><img src="image/defaultHead.png" height="30px" width="30px" alt="Head Picure"/></td>
    </tr>
    </table>
</div>
>>>>>>> origin/master
