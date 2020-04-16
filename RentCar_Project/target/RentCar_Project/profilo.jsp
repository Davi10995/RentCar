<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 15/04/2020
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/navbar.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="topnav">
    <a  class="active" href="list">Home</a>
    <a href="#">Profilo</a>
    <a href="parcoAuto">Parco Auto</a>
    <div class="login-container">
        <p class="userName">Welcome ${name}</p>
        <form action="logout" method="post" >
            <button type="submit">Logout</button>
        </form>
    </div>
</div>
<button onclick="window.location.href = 'userReservation';">Le mie Prenotazioni</button>
</body>
</html>
