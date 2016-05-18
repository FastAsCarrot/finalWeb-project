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

<div style = "color: red">
    <c:out value = "${message}"/>
</div>


<h1>Profile of <c:out value = "${sessionScope.client.name}"/></h1>

Name: <c:out value = "${sessionScope.client.name}"/><br>
Login: <c:out value = "${sessionScope.client.login}"/><br>
Role: <c:out value = "${sessionScope.role.name}"/><br>
<br>

<c:if test = "${sessionScope.role.name == 'User'}">
    <a href = "AddingBankCard.jsp">Add a bank card</a><br>
    <a href = "/CardInformationServlet">Cards information</a><br>
    <a href = "CardOperationsServlet">Operations with card</a>
</c:if>

<c:if test = "${sessionScope.role.name == 'Administrator'}">
    <a href = "/InitializeBankAccountsServlet">Unblock account</a><br>
    <a href = "/InitializeBankCardsServlet">View all cards</a><br>
    <a href = "/InitializeUsersServlet">View all users</a><br>
</c:if>

</body>
</html>
