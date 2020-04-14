<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>User Management</title>
    <link href="/css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    if(session.getAttribute("name") == null)
        response.sendRedirect("/login.jsp");
%>

<ul>
    <li><a href="home.jsp">Home</a></li>
    <li><a href="/logout">Logout</a></li>
    <li><a href="/parcoAuto">Parco Auto</a></li>
    <li class="userName">Welcome ${name}</li>
</ul>
<div style="text-align: center;">
    <h1>User Management</h1>
</div>
<div align="center">
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
    <a href="/newVeicolo.jsp">Aggiungi un Veicolo</a>
</div>
</body>
</html>
