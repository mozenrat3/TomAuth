<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>

<td>Username: </td>
<td><input type="text" value="${user.login}" /></td>
<br>
<br>
<td>Password: </td>
<td><input type="text" value="${user.password}" /></td>
<br><br>
<a href="<c:url value='/logout' />">Logout</a>
<br>
<a href="<c:url value='/loginedit' />">PassEdit</a>


<%--<a href="/${pageContext.request.contextPath}/inner">Inner Page</a>--%>
</body>
</html>
