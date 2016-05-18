<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 16.05.2016
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session ="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Card operations</title>
    <script type="text/javascript" src="../scripts/actionChoices.js"></script>
</head>
<body>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<br>
<br>
Choose a card:

<form method = "post" name = "choices">
<select name ="chosenCard">
    <c:forEach var = "card" items = "${sessionScope.cards}">
        <option value = "${card.bankAccountId}">card №<c:out value = "${card.number}"/></option>
    </c:forEach>
</select>
    <br>
    <br>

    <input type = "submit" value = "Block account" onclick = "return blockAccount()"><br>
    <input type = "submit" value = "Add money" onclick = "return addMoney()"><br>
    <input type = "submit" value = "Withdraw money" onclick = "return withdrawMoney()"><br>
</form>

</body>
</html>
