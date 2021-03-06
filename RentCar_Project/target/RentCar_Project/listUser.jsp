<%@ page import="static javafx.beans.binding.Bindings.when" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
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
            <label>Ricerca <input id="search_input" size="30" name="keyword" /></label>
            <select name="filtroRicerca" id="filtro">
                <option value="nome">Nome</option>
                <option value="cognome">Cognome</option>
            </select>
            <input type="image" src="${pageContext.request.contextPath}/logo/search.png" id="image" />
        </form>
        <table border="1" cellpadding="5">
            <tr class="column-header">
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
                <c:if test= "${user.tipo == 'Customer'}">
                    <tr class="riga">
                            <td><c:out value="${user.cf}" /></td>
                            <td class="nome"><c:out value="${user.nome}" /></td>
                            <td class="cognome"><c:out value="${user.cognome}" /></td>
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

                    </tr>
                </c:if>
            </c:forEach>
        </table>
            <script>

            if(document.getElementById("filtro").value === 'nome') {
                console.log('qui si');
                $('#search_input').on('keyup', function () {
                    var value = $(this).val();
                    $('tr.riga').hide();//hide all record
                    var tableRow = $("td.nome").filter(function() {
                        if($(this).text().indexOf(value)  >= 0 ){
                            return $(this);
                        }
                    }).closest("tr"); // alternative to .parent()
                console.log(tableRow.text());
                tableRow.show();
                });

            }else{
                $(function () {
                    $('#search_input').on('keyup', function () {
                        var value = $(this).val();
                        console.log(value);
                        $('table').hide();//hide all record
                        $('table').filter(function () {
                            return $(this).find('cognome').val().indexOf(value) != -1;
                        }).show();
                    });
                });
            }
            </script>

        </div>
    </body>
</html>
