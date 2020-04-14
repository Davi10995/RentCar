<%@ page import="static javafx.beans.binding.Bindings.when" %>
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
    <%
    if(session.getAttribute("name") == null)
        response.sendRedirect("/login.jsp");
    %>

    <div class="topnav">
        <a href="home.jsp">Home</a>
        <a href="#">Profilo</a>
        <a href="/parcoAuto">Parco Auto</a>
        <div class="login-container">
            <form action="/logout" method="post" >
                <button type="submit">Logout</button>
            </form>
        </div>
    </div>
    <div style="text-align: center;">
        <h1>User Management</h1>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users</h2></caption>
            <tr>
                <th>CF</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Tipo</th>
                <th>Data</th>
            </tr>

            <c:forEach var="user" items="${listUser}">
                <tr>
                    <c:if test= "${user.tipo =='Customer' }">
                    <td><c:out value="${user.cf}" /></td>
                    <td><c:out value="${user.nome}" /></td>
                    <td><c:out value="${user.cognome}" /></td>
                    <td><c:out value="${user.tipo}" /></td>
                    <td><c:out value="${user.data}" /></td>

                        <td>
                            <a href="${pageContext.request.contextPath}/editForm?id=<c:out value='${user.id}' />">Edit</a>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${user.id}' />">Delete</a>

                            <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${user.id}' />">Visualizza Prenotazioni</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
        <a href="./newUser.jsp">Add New User</a>
    </div>
</body>
</html>
