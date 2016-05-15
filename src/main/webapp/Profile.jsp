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
<a href = "AddingBankCard.jsp">Add a bank card</a><br>
<a href = "/ProfileInformationServlet">Profile information</a>


</body>
</html>
