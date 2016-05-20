<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 18.05.2016
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style/ElementsStyle.css">
    <link rel="stylesheet" type="text/css" href="/style/TableStyle.css">
    <title>View all users</title>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>
<h3><fmt:message key = "admin.users"/></h3>
<div style="overflow-y:auto;">
    <table id = "tables">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>login</th>
            <th>password</th>
            <th>roleId</th>
        </tr>
        <c:forEach var="User" items="${requestScope.users}">
            <tr>
                <td><c:out value = "${User.id}"/></td>
                <td><c:out value="${User.name}" /></td>
                <td><c:out value="${User.login}" /></td>
                <td><c:out value="${User.password}" /></td>
                <td><c:out value ="${User.roleId}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
