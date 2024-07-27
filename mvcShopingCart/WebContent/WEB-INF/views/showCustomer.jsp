<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/30/2024
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>
<c:set var = "customerInfo" value="${customerInfo}"/>
    <h2>Below is the information you filled</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Mobile</th>
            <th>Address</th>
            <th>UserName</th>
            <th>Password</th>
        </tr>
        <tr>
            <td>${customerInfo.customerName}</td>
            <td>${customerInfo.customerEmail}</td>
            <td>${customerInfo.customerMobile}</td>
            <td>${customerInfo.customerAddress}</td>
            <td>${customerInfo.customerUserName}</td>
            <td>${customerInfo.customerPassword}</td>

        </tr>
    </table>
<br>

<a href="getAllCustomer">View all Customers</a><br>

<a href="form">Add Another Customer</a>
</body>
</html>
