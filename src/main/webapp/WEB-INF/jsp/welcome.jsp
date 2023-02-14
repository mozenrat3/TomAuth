<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/welcome.css" rel="stylesheet" type="text/css">
    <title>Welcome</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div id="menu">
    <jsp:include page="menu.jsp"></jsp:include>
</div>
<main>
    <h1> Welcome to main page our app</h1>
</main>
<%--<td>Username: </td>--%>
<%--<td><input type="text" value="${user.login}" /></td>--%>
<%--<br>--%>
<%--<br>--%>
<%--<td>Password: </td>--%>
<%--<td><input type="text" value="${user.password}" /></td>--%>
<%--<br><br>--%>
<%--<a href="<c:url value='/logout' />">Logout</a>--%>
<%--<br>--%>
<%--<a href="<c:url value='/loginedit' />">PassEdit</a>--%>
</body>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>

</html>
