<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 07.05.2016
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session = "true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${sessionScope.locale}"/>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/ElementsStyle.css">
    <title>Profile</title>
</head>
<body>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>


<h1><fmt:message key = "profile.profileOf"/> <c:out value = "${sessionScope.client.name}"/></h1>

<div id = "profileText">
<fmt:message key = "profile.name"/> <c:out value = "${sessionScope.client.name}"/><br>
<fmt:message key = "profile.login"/> <c:out value = "${sessionScope.client.login}"/><br>
<fmt:message key = "profile.role"/> <c:out value = "${sessionScope.role.name}"/><br>
<br>
</div>
<br>
<c:if test = "${sessionScope.role.name == 'User'}">
    <a href = "userPages/AddingBankCard.jsp"> <fmt:message key = "profile.addCard"/></a><br>
    <a href = "/CardInformationServlet"> <fmt:message key = "profile.cardInfo"/></a><br>
    <a href = "/CardOperationsServlet"> <fmt:message key = "profile.cardOperations"/></a>
</c:if>

<c:if test = "${sessionScope.role.name == 'Administrator'}">
    <a href = "/InitializeBankAccountsServlet"> <fmt:message key = "profile.unblock"/></a><br>
    <a href = "/InitializeBankCardsServlet"> <fmt:message key = "profile.viewCards"/></a><br>
    <a href = "/InitializeUsersServlet"> <fmt:message key = "profile.viewUsers"/></a><br>
</c:if>

</body>
</html>
