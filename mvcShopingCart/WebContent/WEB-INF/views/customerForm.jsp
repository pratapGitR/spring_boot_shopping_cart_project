<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/28/2024
  Time: 4:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
</head>
<body>
<b><i><font color="green" size="10">Welcome to Customer Registration Form.</font></i></b><br>
<br>
Please fill the form below!!
<form action="saveCustomer" method="post">
    <div>
        <label for ="customerName">Name :</label>
        <input type="text" name="customerName" id="customerName" required>
    </div>
    <div>
        <label for ="customerEmail">Email :</label>
        <input type="email" name="customerEmail" id="customerEmail" required>
    </div>
    <div>
        <label for ="customerMobile">Mobile Number :</label>
        <input type="tel" name="customerMobile" id="customerMobile" required>
    </div>
    <div>
        <label for ="customerAddress">Address :</label>
        <input type="text" name="customerAddress" id="customerAddress" required>
    </div>
    <div>
        <label for ="customerUserName">User Name :</label>
        <input type="text" name="customerUserName" id="customerUserName" required>
    </div>
    <div>
        <label for ="customerPassword">Password :</label>
        <input type="text" name="customerPassword" id="customerPassword" required>
    </div>
    <div>
        <input type="submit" name="Submit" value="Submit">
    </div>

</form>
<br>
<br>
<%--<a href="http://localhost:8080/mvcShopingCart_war_exploded/allItems">Display All items</a>--%>

</body>
</html>
