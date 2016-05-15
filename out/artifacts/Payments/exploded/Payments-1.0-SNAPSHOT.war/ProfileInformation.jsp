<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 15.05.2016
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session ="true"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/ProfileInfo.css">
    <title>ProfileInfo</title>
</head>
<body>
<h3>Profile info</h3>
Name: <c:out value = "${sessionScope.client.name}"/><br>
Login: <c:out value = "${sessionScope.client.login}"/><br>
Role: <c:out value = "${sessionScope.role.name}"/><br>
<br>

<h3>Card info</h3>
<table>
    <tr>
        <th>owner</th>
        <th>number</th>
        <th>cvv</th>
        <th>expires</th>
    </tr>
    <c:forEach var="BankCard" items="${sessionScope.cards}">
        <tr>
            <td><c:out value = "${sessionScope.client.name}"/></td>
            <td><c:out value="${BankCard.number}" /></td>
            <td><c:out value="${BankCard.cvv}" /></td>
            <td><c:out value="${BankCard.expires}" /></td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
