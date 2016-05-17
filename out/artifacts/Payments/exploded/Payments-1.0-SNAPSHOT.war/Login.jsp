<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 07.05.2016
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<form action = "/LoginServlet" method = "get">
Login:<input type="text" name="login"><br>
Password:<input type="password" name="password"><br>
<input type = "submit" value = "login">
</form>
</body>
</html>
