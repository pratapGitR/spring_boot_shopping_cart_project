<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/19/2024
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display User</title>
</head>
<body>
<table>
    <tr>
        <th>Item name</th>
        <th>Item Quantity</th>
        <th>Item Price</th>
        <th>Item Type</th>
    </tr>
    <c:forEach var="item" items="${allItems}">
        <tr>
            <td><c:out value="${item.itemName}"/></td>
            <td><c:out value="${item.itemQuantity}"/></td>
            <td><c:out value="${item.itemPrice}"/></td>
            <td><c:out value="${item.itemType}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>