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
    <div style="text-align: center;">
        <h1>User Management</h1>
    </div>
    <div align="center">
        <table border="1" cellpadding="5">
            <h2>List of Users</h2>
            <tr>
<%--                <th>CF</th>--%>
<%--                <th>Nome</th>--%>
<%--                <th>Cognome</th>--%>
<%--                <th>Tipo</th>--%>
<%--                <th>Data</th>--%>
<%--            </tr>--%>
            <td>
                <form action="list">
                    <input TYPE="submit" value="List of Users">
                </form>
            </td>
<%--            <c:forEach var="user" items="${requestScope.listUser}">--%>
<%--                <tr>--%>
<%--                    <td><c:out value="${user.cf}" /></td>--%>
<%--                    <td><c:out value="${user.nome}" /></td>--%>
<%--                    <td><c:out value="${user.cognome}" /></td>--%>
<%--                    <td><c:out value="${user.tipo}" /></td>--%>
<%--                    <td><c:out value="${user.data}" /></td>--%>
            </tr>
<%--            </c:forEach>--%>
        </table>
    </div>
</body>
</html>