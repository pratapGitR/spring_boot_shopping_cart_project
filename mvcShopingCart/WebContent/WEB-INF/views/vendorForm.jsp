<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/28/2024
  Time: 4:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vendor Registration Form</title>
</head>

<body>
<b><i><font color="green" size="10">Welcome to Vendor Registration Form.</font></i></b><br>
<br>
Please fill the form below!!
<form action="saveVendor" method="post">
    <div>
        <label for ="vendorName">Name :</label>
        <input type="text" name="vendorName" id="vendorName" required>
    </div>
    <div>
        <label for ="vendorEmail">Email :</label>
        <input type="email" name="vendorEmail" id="vendorEmail" required>
    </div>
    <div>
        <label for ="vendorMobile">Mobile Number :</label>
        <input type="tel" name="vendorMobile" id="vendorMobile" required>
    </div>
    <div>
        <label for ="vendorAddress">Address :</label>
        <input type="text" name="vendorAddress" id="vendorAddress" required>
    </div>
    <div>
        <label for ="vendorUserName">User Name :</label>
        <input type="text" name="vendorUserName" id="vendorUserName" required>
    </div>
    <div>
        <label for ="vendorPassword">Password :</label>
        <input type="text" name="vendorPassword" id="vendorPassword" required>
    </div>
    <div>
        <label for ="vendorRegistration">Registration Number :</label>
        <input type="text" name="vendorRegistration" id="vendorRegistration" required>
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
