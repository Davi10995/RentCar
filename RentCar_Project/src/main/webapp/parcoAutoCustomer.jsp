<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 10/04/2020
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/navbar.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    if(session.getAttribute("name") == null)
        response.sendRedirect("/login.jsp");
%>

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

    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>Targa</th>
            <th>Modello</th>
            <th>Casa Costruttrice</th>
            <th>Anno Immatricolazione</th>
        </tr>

        <c:forEach var="veicolo" items="${listVeicoli}">
            <tr>
                <td><c:out value="${veicolo.targa}" /></td>
                <td><c:out value="${veicolo.modello}" /></td>
                <td><c:out value="${veicolo.casaCostrutt}" /></td>
                <td><c:out value="${veicolo.annoImm}" /></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
