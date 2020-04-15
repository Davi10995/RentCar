<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 15/04/2020
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
<form action="newReservation" method="post" >
    Data Inizio Prenotazione:<input type="date" name="dataInizio "/><br/><br/>
    Data Fine Prenotazione:<input type="date" name="dataFine"/><br/><br/>
    <input type="submit" value="Save" />
</form>
</body>
</html>
