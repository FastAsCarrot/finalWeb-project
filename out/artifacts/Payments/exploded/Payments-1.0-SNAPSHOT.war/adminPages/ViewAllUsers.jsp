<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 18.05.2016
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View all users</title>
</head>
<body>
<h3>Users</h3>
<table id = "tables">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>login</th>
        <th>password</th>
        <th>roleId</th>
    </tr>
    <c:forEach var="Users" items="${requestScope.users}">
        <tr>
            <td><c:out value = "${Users.id}"/></td>
            <td><c:out value="${Users.name}" /></td>
            <td><c:out value="${Users.login}" /></td>
            <td><c:out value="${Users.password}" /></td>
            <td><c:out value ="${Users.roleId}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
