<%@ page import="static javafx.beans.binding.Bindings.when" %>
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
    <div style="text-align: center;">
    </div>
    <div align="center">
        <caption><h2>Utenti</h2></caption>
        <form id="search_form" action="#" method="post">
            <select name="filtroRicerca">
                <option value="Nome">Nome</option>
                <option value="Cognome">Cognome</option>
            </select>
            <label>Ricerca <input id="search_input" size="30" name="keyword" /></label>
            <input type="image" src="${pageContext.request.contextPath}/logo/search.png" id="image" />
        </form>
        <script type="text/javascript">
            $(document).ready
        </script>
        <table border="1" cellpadding="5">
            <tr>
                <th>CF</th>
                <th>Nome</th>
                <th>Cognome</th>
                <th>Tipo</th>
                <th>Data</th>
            </tr>
            <c:if test="${sessionScope.tipo == 'SuperUser'}">
                <button onclick="window.location.href = './newUser.jsp';">Aggiungi Utente</button>
            </c:if>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <c:if test= "${user.tipo == 'Customer'}">
                        <td><c:out value="${user.cf}" /></td>
                        <td><c:out value="${user.nome}" /></td>
                        <td><c:out value="${user.cognome}" /></td>
                        <td><c:out value="${user.tipo}" /></td>
                        <td><c:out value="${user.data}" /></td>
                        <c:if test="${sessionScope.tipo == 'SuperUser'}">
                            <td>
                                <a href="${pageContext.request.contextPath}/editForm?id=<c:out value='${user.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${user.id}' />">Delete</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="${pageContext.request.contextPath}/reservationList?id=<c:out value='${user.id}' />">Visualizza Prenotazioni</a>
                            </td>
                        </c:if>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
