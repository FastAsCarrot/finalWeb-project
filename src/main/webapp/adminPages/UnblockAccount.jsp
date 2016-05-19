<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 18.05.2016
  Time: 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/ElementsStyle.css">
    <title>Unblock account</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<fmt:message key = "admin.listOfBlocked"/> <br>
<form action = "/UnblockAccountServlet" method = "post">
    <select name = "bankAccountId">
        <c:forEach var ="account" items = "${requestScope.bankAccounts}">
            <c:if test = "${account.isBlocked == true}">
                <option value = "${account.id}"><c:out value = "${account.id}"/></option>
            </c:if>
        </c:forEach>
    </select>
    <br>
    <fmt:message key = "admin.unblock" var = "unblock"/>
    <input type ="submit" value = "${unblock}">
</form>
</body>
</html>
