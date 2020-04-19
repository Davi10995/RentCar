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
    <div align="center">
        <table border="1" cellpadding="5">
            <h2>BENVENUTO IN RENTALCAR BY DAVIDE CORDA</h2>
            <tr>
                <td>
                    <form action="list">
                        <input TYPE="submit" value="ENTRA NEL SITO">
                    </form>
                </td>
            </tr>
        </table>
    </div>
</body>
</html>