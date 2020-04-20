<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09/04/2020
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>User Management</title>
    <link href="css/navbar.css" rel="stylesheet" type="text/css">
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
        <h2>Nuovo Utente</h2>
        <form action="newUser" method="post" >
            CF:<input type="text" name="cf"/><br/><br/>
            Nome:<input type="text" name="nome"/><br/><br/>
            Cognome:<input type="text" name="cognome"/><br/><br/>
            Password:<input type="text" name="password"/><br/><br/>
            Data:<input type="date" name="data" max="datetime local" value="2020-01-08"/><br/><br/>
            <input type="submit" value="Save" />
        </form>
    </div>
</body>
</html>
