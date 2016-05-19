<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 14.04.2016
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <link rel="stylesheet" type="text/css" href="/style/ElementsStyle.css">
    <title>Payments system, biach !</title>
  </head>
  <body>

  <fmt:setLocale value="${sessionScope.locale}"/>

  <ul>
    <li><a href="/RussianLocaleServlet" name = "ru" id = "ru"><fmt:message key = "main.ru"/></a></li>
    <li><a href="/EnglishLocaleServlet" name = "en" id = "eng"><fmt:message key = "main.en"/></a></li>
    <li><a href = "/ProfileServlet" id = "profile"><fmt:message key = "main.Profile"/></a></li>
    <li><a href = "/LogoutServlet" id = "signout"><fmt:message  key = "main.SignOut"/></a></li>
  </ul>


  <div style = "color: red">
    <c:out value = "${message}"/>
  </div>

  <div align = "center"><h1><fmt:message key = "main.Welcome"/></h1></div>
  <a href = "Login.jsp"><fmt:message key = "main.SignIn"/></a><br>
  <a href = "Registration.jsp"><fmt:message key ="main.Registration"/></a><br>


  </body>
</html>
