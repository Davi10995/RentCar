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
    <link href="/css/style.css" rel="stylesheet" type="text/css">

</head>
<body>
    <ul>
        <li><a href="home.jsp">Home</a></li>
        <li><a href="/logout">Logout</a></li>
        <li><a href="/parcoAuto">Parco Auto</a></li>
        <li class="userName">Welcome ${name}</li>
    </ul>

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
                <td>
                    <a href="${pageContext.request.contextPath}/editVehicle?id=<c:out value='${user.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="${pageContext.request.contextPath}/deleteVehicle?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
