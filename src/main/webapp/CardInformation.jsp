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
    <link rel="stylesheet" type="text/css" href="/style/CardInfo.css">
    <title>ProfileInfo</title>
</head>
<body>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<h3>Card info</h3>
<table id = "tables">
    <tr>
        <th>owner</th>
        <th>number</th>
        <th>cvv</th>
        <th>expires</th>
        <th>funds</th>
        <th>blocked</th>
    </tr>
    <c:forEach var="BankCard" items="${sessionScope.cards}" varStatus ="status">
        <tr>
            <td><c:out value = "${sessionScope.client.name}"/></td>
            <td><c:out value="${BankCard.number}" /></td>
            <td><c:out value="${BankCard.cvv}" /></td>
            <td><c:out value="${BankCard.expires}" /></td>
            <td><c:out value ="${sessionScope.bankAccounts[status.index].amount}"/></td>
            <td><c:out value = "${sessionScope.bankAccounts[status.index].isBlocked}"/></td>
        </tr>
    </c:forEach>
</table>

</body>

</html>
