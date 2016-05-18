<%--
  Created by IntelliJ IDEA.
  User: vrama
  Date: 14.04.2016
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    <title>Payments system, biach !</title>
  </head>
  <body>

  <div style = "color: red">
    <c:out value = "${message}"/>
  </div>
  <div align="right">
      <a href = "/ProfileServlet">Profile</a>
      <a href = "/LogoutServlet">Sign Out</a>
  </div>

  <div align = "center"><h1>Welcome to THE BANK</h1></div>
  <a href = "Login.jsp">Sign In</a><br>
  <a href = "Registration.jsp">Registration</a><br>

  </body>
</html>
