<%--
  Created by IntelliJ IDEA.
  User: david
  Date: 07/04/2020
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<input type="hidden" name="id" value="<c:out value='${user.id}' />" />

<tr>
    <th>User Name (CF): </th>
    <td>
        <input type="text" name="cd" size="45"
               value="<c:out value='${user.cf}' />"
        />
    </td>
</tr>
<tr>
    <th>Password: </th>
    <td>
        <input type="text" name="password" size="45"
               value="<c:out value='${user.cognome}' />"
        />
    </td>
</tr>
</body>
</html>
