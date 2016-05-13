<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 07.05.2016
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<jsp:useBean id = "client" class = "dao.entities.Client" scope = "session">
</jsp:useBean>


<h1>Profile of <jsp:getProperty property = "name" name = "client"></jsp:getProperty></h1>
<a href = "AddingBankCard.jsp">Add a bank card</a><br>
</body>
</html>
