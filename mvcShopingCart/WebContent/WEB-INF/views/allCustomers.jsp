<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Below is the information of ALL CUSTOMERS</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Mobile</th>
        <th>Address</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="customer" items="${customers}">
    <tr>
        <td>${customer.customerName}</td>
        <td>${customer.customerEmail}</td>
        <td>${customer.customerMobile}</td>
        <td>${customer.customerAddress}</td>
        <td>${customer.customerUserName}</td>
        <td>${customer.customerPassword}</td>
        <td><a href="editCustomer">edit</a></td>
        <td><a href="deleteCustomer">delete</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
