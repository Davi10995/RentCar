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
        <link href="css/navbar.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="topnav">
            <a  class="active" href="home.jsp">Home</a>
            <a href="#">Profilo</a>
            <a href="parcoAuto">Parco Auto</a>
            <div class="login-container">
                <p class="userName">Welcome ${name}</p>
                <form action="logout" method="post" >
                    <button type="submit">Logout</button>
                </form>
            </div>
        </div>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="/logout">Logout</a></li>
            <li><a href="/parcoAuto">Parco Auto</a></li>
            <li class="userName">Welcome ${name}</li>
        </ul>
        <form action="newVeicolo" method="post" >
            Targa:<input type="text" name="targa"/><br/><br/>
            Modello:<input type="text" name="modello"/><br/><br/>
            Casa Costruttrice:<input type="text" name="casa"/><br/><br/>
            Anno Immatricolazione:<input type="text" name="anno"/><br/><br/>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
