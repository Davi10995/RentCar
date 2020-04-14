<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 09/04/2020
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <%@ page isELIgnored="false" %>
    <title>Delete</title>
</head>
<body>
    <h1>STAI PER ELIMINARE <c:out value='${user.nome}'/> <c:out value='${user.cognome}' />, SEI SICURO?</h1>
    <a href="${pageContext.request.contextPath}/deleteUser?id=<c:out value='${user.id}' />" class="button buttonYes">Si</a>
    <a href="${pageContext.request.contextPath}/list" class="button buttonNo">No</a>
</body>
</html>
