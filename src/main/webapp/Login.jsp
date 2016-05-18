<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 07.05.2016
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

<fmt:setLocale value="${sessionScope.locale}"/>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<form action = "/LoginServlet" method = "get">
    <fmt:message key = "log.login"/><input type="text" name="login"><br>
    <fmt:message key = "log.password"/><input type="password" name="password"><br>
    <fmt:message key = "log.submit" var = "sub"/>
<input type = "submit" value = "${sub}">
</form>
</body>
</html>
