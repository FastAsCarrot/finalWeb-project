<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 03.05.2016
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<form action="/RegistrationServlet" method="post">
    Name:<input type="text" name="name"><br>
    Login:<input type="text" name="login"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="login">
</form>
</body>
</html>