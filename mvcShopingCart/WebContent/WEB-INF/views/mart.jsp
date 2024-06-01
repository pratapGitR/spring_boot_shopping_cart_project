<%--
  Created by IntelliJ IDEA.
  User: work
  Date: 5/19/2024
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<b><i><font color="green" size="10">Welcome to mart.</font></i></b><br>
<br>
Please fill the items you need!!
<form action="saveItem" method="post">
<div>
    <label for ="itemName">Item Name:</label>
    <input type="text" name="itemName" id="itemName" required>
</div>
    <div>
        <label for ="itemType">Item Type:</label>
        <input type="text" name="itemType" id="itemType" required>
    </div>
    <div>
        <label for ="itemQuantity">Item Quantity:</label>
        <input type="text" name="itemQuantity" id="itemQuantity" required>
    </div>
    <div>
        <label for ="itemPrice">Item Price:</label>
        <input type="text" name="itemPrice" id="itemPrice" required>
    </div>
    <div>
        <input type="submit" name="Submit" value="Submit">
    </div>

</form>
<br>
<br>
<a href="http://localhost:8080/mvcShopingCart_war_exploded/allItems">Display All items</a>

</body>
</html>
