<%--
  Created by IntelliJ IDEA.
  User: codecadet
  Date: 25/03/2021
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>form</title>
</head>
<body>
<h1>Register page</h1>
<form action="http://localhost:8080/hello/form" method="POST">
    <label for="firstname">First Name: </label>
    <input type="text" name="firstname" id="firstname" required minlength="4" maxlength="12"/>
    <br><br>
    <label for="lastname">Last Name: </label>
    <input type="text" id="lastname" name="lastname" required minlength="4" maxlength="12"/>
    <br><br>
    <label for="number">Number: </label>
    <input type="number" id="number" name="amount" min="9" max="9"/>
    <br><br>
    <label for="email">Email: </label>
    <input type="email" id="email" name="email"/>
    <br><br>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
