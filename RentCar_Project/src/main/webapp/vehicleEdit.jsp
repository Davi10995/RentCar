<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 15/04/2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <%@ page isELIgnored="false" %>
        <title>User Management</title>
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
    <br/><br/><br/><br/>
        <form action="editVehicle" method="post" >
            <input type="hidden" name="id" value="<c:out value='${veicolo.id}' />">
            <input type="hidden" name="prenotabile" value="<c:out value='${veicolo.prenotabile}' />">
            Targa:<input type="text" name="targa"/><br/><br/>
            Casa Costruttrice:<select name="casa" value="<c:out value='${veicolo.casaCostrutt}' />">
            <option value="Audi">Audi</option>
            <option value="Citroen">Citroen</option>
            <option value="Fiat">Fiat</option>
            <option value="Peugeot">Peugeot</option>
            <option value="Saab">Saab</option>
            <option value="VolksWagen">VolksWagen</option>
            <option value="Volvo">Volvo</option>
            </select><br/><br/>
            Modello:<select name="modello" value="<c:out value='${veicolo.modello}' />">
            <option value="Berlina">Berlina</option>
            <option value="Coupe'">Coupè</option>
            <option value="StationWagon">Station Wagon</option>
            <option value="Spider">Spider</option>
            </select><br/><br/>
            Anno Immatricolazione:<input type="text" name="anno" value="<c:out value='${veicolo.annoImm}' />"/><br/><br/>
            <input type="submit" value="Save" />
        </form>
    </body>
</html>
