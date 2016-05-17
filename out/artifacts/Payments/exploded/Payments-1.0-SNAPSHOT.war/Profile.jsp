<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 07.05.2016
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session = "true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Profile</title>
</head>
<body>

<h1>Profile of <c:out value = "${sessionScope.client.name}"/></h1>

Name: <c:out value = "${sessionScope.client.name}"/><br>
Login: <c:out value = "${sessionScope.client.login}"/><br>
Role: <c:out value = "${sessionScope.role.name}"/><br>
<br>

<a href = "AddingBankCard.jsp">Add a bank card</a><br>
<a href = "/CardInformationServlet">Cards information</a><br>
<a href = "CardOperationsServlet">Operations with card</a>

</body>
</html>
