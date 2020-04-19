<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 14/04/2020
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Lista Prenotazioni</title>
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
        <table border="1" cellpadding="5">
            <caption><h2>Prenotazioni</h2></caption>
            <tr>
                <th>Nome Utente</th>
                <th>Veicolo</th>
                <th>Data inizio</th>
                <th>Data fine</th>
            </tr>

            <c:forEach var="prenotazione" items="${listPrenotazioni}">
                <tr>
                        <td><c:out value="${prenotazione.user.nome}" /></td>
                        <td><c:out value="${prenotazione.veicolo.modello}" /></td>
                        <td><c:out value="${prenotazione.dataInizio}" /></td>
                        <td><c:out value="${prenotazione.dataFine}" /></td>

                        <td>
                            <a href="${pageContext.request.contextPath}/editForm?id=<c:out value='${prenotazione.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${prenotazione.id}' />">Delete</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                        </td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>
