<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 18.05.2016
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/ElementsStyle.css">
    <link rel="stylesheet" type="text/css" href="/style/TableStyle.css">
    <title>View All Cards</title>
</head>
<body>

<fmt:setLocale value="${sessionScope.locale}"/>

<h3><fmt:message key = "admin.cards"/> </h3>
<table id = "tables">
    <tr>
        <th>id</th>
        <th>bankAccountId</th>
        <th>ownerId</th>
        <th>number</th>
        <th>cvv</th>
        <th>expires</th>
        <th>pin</th>
    </tr>
    <c:forEach var="Card" items="${requestScope.cards}">
    <tr>
        <td><c:out value="${Card.id}"/></td>
        <td><c:out value="${Card.bankAccountId}" /></td>
        <td><c:out value="${Card.ownerId}"/></td>
        <td><c:out value="${Card.number}"/></td>
        <td><c:out value ="${Card.cvv}"/></td>
        <td><c:out value ="${Card.expires}"/></td>
        <td><c:out value ="${Card.pin}"/></td>
    </tr>
    </c:forEach>

</body>
</html>
