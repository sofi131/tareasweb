<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tomas
  Date: 27/02/2024
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="" method="post">
    <label for="user">Usuario</label>
    <input id="user" type="text" name="user">
    <label for="password">Password</label>
    <input id="password" type="password" name="password">
    <input type="submit" name="Login">
</form>
<c:if test="${mensaje!=null}">
    <p>${mensaje}</p>
</c:if>
</body>
</html>
