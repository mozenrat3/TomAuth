<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Login Edit</title>
</head>
<body>
<t:headers></t:headers>
<td>Username:</td>
<td><input type="text" value="${user.login}"/></td>
<br>
<br>
<td>Password:</td>
<td><input type="text" value="${user.password}"/></td>
<br>
<form method="post" action="">
    <%--    <input name="login">--%>
    <%--    <button type="submit" >Send</button>--%>

    <label>Введите Ваш логин</label>
    <input type="text" name="login" placeholder="Введите Ваш логин" required>
    <br>
    <label>Введите старый пароль</label>
    <input type="password" name="password" placeholder="Введите ваш пароль" required>
    <br>
    <label>Введите новый пароль</label>
    <input type="password" name="newpassword" placeholder="Введите новый пароль" required>
    <br>
    <label>Подтвердите пароль</label>
    <input type="password" name="comfirmpassword" placeholder="Подтвердите пароль" required>
    <button class="form_auth_button" type="submit" name="form_auth_submit">Изменить</button>
    <br>
    <br>
    <a href="<c:url value='/welcome' />">Main Page</a>
    <br>

</body>
<t:footers></t:footers>
</html>
