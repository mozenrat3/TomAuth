<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
Здравствуйте, введите ваши данные для авторизации
<%--<p><c:out value = "${requestScope.dataForView}"/></p>--%>
<br>
<%--/${pageContext.request.contextPath}/login --%>
<form method="post" action="">
<%--    <input name="login">--%>
<%--    <button type="submit" >Send</button>--%>
    <label>Введите Ваш логин</label>
    <input type="text" name="login" placeholder="Введите Ваш логин" required >
    <br>
    <br>
    <label>Введите Ваш пароль</label>
    <input type="password" name="password" placeholder="Введите пароль" required >
    <button class="form_auth_button" type="submit" name="form_auth_submit">Войти</button>
    <br>
    <br>
<%--    <a href="<c:url value='/welcome' />">Main Page</a>--%>
<%--    <a href="/${pageContext.request.contextPath}/welcome">Welcome Page</a>--%>
    <br>

<%--    <input type="hidden" name="redirect" value="${pageContext.request.contextPath}/welcome">--%>

<%--    <c:if test="${val == 1}">--%>
<%--        <c:redirect url="/welcome" />--%>
<%--    </c:if>--%>
</form>
</body>
</html>
