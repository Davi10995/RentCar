<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div  align="center">
            <h1 >Stai prenotando il seguente veicolo</h1>
            <table border="1" cellpadding="5">
                <tr>
                    <th>Targa</th>
                    <th>Modello</th>
                    <th>Casa Costruttrice</th>
                    <th>Anno Immatricolazione</th>
                </tr>
                    <tr>
                        <td><c:out value="${veicolo.targa}" /></td>
                        <td><c:out value="${veicolo.modello}" /></td>
                        <td><c:out value="${veicolo.casaCostrutt}" /></td>
                        <td><c:out value="${veicolo.annoImm}" /></td>
                    </tr>
            </table>
                <h3>Inserisci la data per procedere con la prenotazione</h3>
            <form action="newReservation" method="post" >
                Data Inizio Prenotazione:<input type="date" name="dataInizio"/><br/><br/>
                Data Fine Prenotazione:<input type="date" name="dataFine"/><br/><br/>
                <input type="hidden" name="id" value="<c:out value='${veicolo.id}' />">
                <input type="submit" value="Save" />
            </form>
        </div>
    </body>
</html>
