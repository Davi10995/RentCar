<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09/04/2020
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <link href="css/navbar.css" rel="stylesheet" type="text/css">
    <%@ page isELIgnored="false" %>
    <title>Delete</title>
</head>
<body>
<div class="topnav">
    <a  class="active" href="list">Home</a>
    <a href="profilo.jsp">Profilo</a>
    <a href="parcoAuto">Parco Auto</a>
    <div class="login-container">
        <p class="userName">Welcome ${name}</p>
        <form action="logout" method="post" >
            <button type="submit">Logout</button>
        </form>
    </div>
</div>
<div align="center">
    <h1>STAI PER ELIMINARE <c:out value='${user.nome}'/> <c:out value='${user.cognome}' />, SEI SICURO?</h1>
    <button onclick="window.location.href = '/deleteUser?id=<c:out value='${user.id}' />'">Si</button>
<%--    <a href="${pageContext.request.contextPath}/deleteUser?id=<c:out value='${user.id}' />" class="button buttonYes">Si</a>--%>
    <button onclick="window.location.href = 'list';">No</button>
</div>
</body>
</html>
