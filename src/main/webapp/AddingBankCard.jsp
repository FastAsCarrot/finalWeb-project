<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 12.05.2016
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BankCardRForm</title>
</head>
<body>
<form action = "/BankCard" method = "get">
    number: <input type = "text" name = "number"><br>
    cvv: <input type = "text" name = "cvv"><br>
    exp: <input type = "date" name = "exp"><br>
    <input type = "submit" value = "Add"><br>
</form>
</body>
</html>
