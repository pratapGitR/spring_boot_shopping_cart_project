<%@ page import="springmvc.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/12/2024
  Time: 6:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <%
        List<User> userList = (ArrayList<User>)request.getAttribute("userModelList");
        for (User user: userList) {

    %>
    <tr>
        <td>
            <%=user.getUserId()%>
        </td>
        <td>
            <%=user.getUserName()%>
        </td>
        <td>
            <%=user.getUserEmail()%>
        </td>
        <td>
            <%=user.getPhoneNumber()%>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
