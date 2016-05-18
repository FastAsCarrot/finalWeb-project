<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 14.04.2016
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>Payments system, biach !</title>
  </head>
  <body>

  <fmt:setLocale value="${sessionScope.locale}"/>

  <div align="left">
    <a href="/RussianLocaleServlet" name = "ru"><fmt:message key = "main.ru"/></a>
    <a href="/EnglishLocaleServlet" name = "en"><fmt:message key = "main.en"/></a>
  </div>

  <div style = "color: red">
    <c:out value = "${message}"/>
  </div>

    <div align="right">
      <a href = "/ProfileServlet"><fmt:message key = "main.Profile"/></a>
      <a href = "/LogoutServlet"><fmt:message  key = "main.SignOut"/></a>
    </div>

  <div align = "center"><h1><fmt:message key = "main.Welcome"/></h1></div>
  <a href = "Login.jsp"><fmt:message key = "main.SignIn"/></a><br>
  <a href = "Registration.jsp"><fmt:message key ="main.Registration"/></a><br>


  </body>
</html>
