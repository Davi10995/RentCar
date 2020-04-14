<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09/04/2020
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=UTF-8"
          pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>User Management</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
    <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a href="/logout">Logout</a></li>
        <li><a href="/parcoAuto">Parco Auto</a></li>
        <li class="userName">Welcome ${name}</li>
    </ul>
    <form action="newUser" method="post" >
        CF:<input type="text" name="cf"/><br/><br/>
        Nome:<input type="text" name="nome"/><br/><br/>
        Cognome:<input type="text" name="cognome"/><br/><br/>
        Password:<input type="text" name="password"/><br/><br/>
        Data:<input type="date" name="data" max="datetime local"/><br/><br/>
        <input type="submit" value="Save" />
    </form>
</body>
</html>
