<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 06.02.2023
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<td>Username: </td>
<td><input type="text" value="<%= session.getAttribute("login") %>" /></td>
<br>
<br>
<td>Password: </td>
<td><input type="text" value="<%= session.getAttribute("password") %>" /></td>
<br><br>
<a href="<c:url value='/logout' />">Logout</a>



<%--<a href="/${pageContext.request.contextPath}/inner">Inner Page</a>--%>
</body>
</html>
