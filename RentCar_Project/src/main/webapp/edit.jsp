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
        <div style="align-content: center">
        <form action="edit" method="post" >
            Nome:<input type="text" name="nome" value="<c:out value='${user.nome}' />"/><br/><br/>
            Cognome:<input type="text" name="cognome" value="<c:out value='${user.cognome}' />"/><br/><br/>
            Password:<input type="text" name="password" value="<c:out value='${user.password}' />"/><br/><br/>
            Tipo:<input type="text" name="tipo" value="<c:out value='${user.tipo}' />"/><br/><br/>
            Data:<input type="date" name="data" max="datetime local" value="<c:out value='${user.data}' />"/><br/><br/>
            <input type="hidden" name="id" value="<c:out value='${user.id}' />">
            <input type="hidden" name="cf" value="<c:out value='${user.cf}' />">
            <input type="submit" value="Save" />
        </form>
        </div>
    </body>
</html>