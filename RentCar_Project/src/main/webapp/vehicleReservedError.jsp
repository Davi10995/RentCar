<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 15/04/2020
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title style="align-content: center">Error</title>
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
    <h1 style="text-align: center">IL VEICOLO RISULTA PRENOTATO E NON MODIFICABILE ORA</h1>
    <a style="align-content: center" href="list"><input type="submit" value="Torna alla Home" /></a>
</div>
</body>
</html>
