<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 16.05.2016
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session ="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head>
    <title>Card operations</title>
    <script type="text/javascript" src="../scripts/actionChoices.js"></script>
</head>
<body>
<fmt:setLocale value="${sessionScope.locale}"/>

<div style = "color: red">
    <c:out value = "${message}"/>
</div>

<br>
<br>
<fmt:message key = "user.chooseCard"/>

<form method = "post" name = "choices">
<select name ="chosenCard">
    <c:forEach var = "card" items = "${sessionScope.cards}">
        <option value = "${card.bankAccountId}">card №<c:out value = "${card.number}"/></option>
    </c:forEach>
</select>
    <br>
    <br>

    <fmt:message key = "user.blockAccount" var = "block"/>
    <input type = "submit" value = "${block}" onclick = "return blockAccount()"><br>
    <fmt:message key = "user.addMoney" var = "add"/>
    <input type = "submit" value = "${add}" onclick = "return addMoney()"><br>
    <fmt:message key = "user.withdrawMoney" var = "withdraw"/>
    <input type = "submit" value = "${withdraw}" onclick = "return withdrawMoney()"><br>
</form>

</body>
</html>
