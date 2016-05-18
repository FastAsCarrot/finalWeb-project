<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 03.05.2016
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<form action="/RegistrationServlet" method="post">
    <fmt:message key = "profile.name"/><input type="text" name="name"><br>
    <fmt:message key = "profile.login"/><input type="text" name="login"><br>
    <fmt:message key = "reg.password"/><input type="password" name="password"><br>
    <fmt:message key = "reg.submit" var = "submt"/>
    <input type="submit" value="${submt}">
</form>
</body>
</html>
