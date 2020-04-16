<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <%@ page isELIgnored="false" %>
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
            <c:if test="${sessionScope.tipo == 'SuperUser'}">
            <button onclick="window.location.href = './newVeicolo.jsp';">Aggiungi Veicolo</button>
            </c:if>
            <table border="1" cellpadding="5">
                <caption><h2>Veicoli</h2></caption>
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
                        <c:if test="${sessionScope.tipo == 'SuperUser'}">
                        <td>
                            <a href="${pageContext.request.contextPath}/editVehicleForm?id=<c:out value='${veicolo.id}' />">Modifica</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/deleteVehicle?id=<c:out value='${veicolo.id}' />">Elimina</a>
                        </td>
                        </c:if>
                        <td>
                        <c:if test = "${veicolo.prenotabile == 'true'}">
                            <a href="${pageContext.request.contextPath}/insertReservation?id=<c:out value='${veicolo.id}' />">Prenota</a>
                        </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </table>
<%--            <a href="./newVeicolo.jsp">Aggiungi un Veicolo</a>--%>
        </div>
    </body>
</html>
