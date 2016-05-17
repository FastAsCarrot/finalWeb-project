<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 12.05.2016
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Bank Card Registration Form</title>
</head>
<body>
<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<form action = "/AddBankCardServlet" method = "post">
    number: <input oninput="lengthTrimming();" type = "number" name = "number" maxlength = "16"><br>
    cvv: <input  oninput="lengthTrimming();" type = "number" name = "cvv" maxlength = "3"><br>
    exp: <input type = "date" name = "exp"><br>
    <input type = "submit" value = "Add"><br>
</form>

<script>
    alert("Remember: length of card number is 16 digits!\n" +
            "Remember: length of cvv is 3 digits!");
</script>

</body>
</html>
