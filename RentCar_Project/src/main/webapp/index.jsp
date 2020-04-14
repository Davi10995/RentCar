<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 07/04/2020
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RENTCAR LOGIN</title>
    <link href="css/navbar.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="topnav">
    <a class="active" href="#home">Home</a>
    <a href="#about">About</a>
    <a href="#contact">Contact</a>
    <div class="login-container">
        <form action="login" method="post" >
            <input type="text" placeholder="CF" name="username"/><br/><br/>
            <input type="password" placeholder="Password" name="password"/><br/><br/>
            <button type="submit">Login</button>
        </form>
    </div>
</div>

<div style="text-align: center;">
    <h1>RentCar Autonoleggio</h1>
</div>
    <img src="logo/logo.jpg">
</body>
</html>

