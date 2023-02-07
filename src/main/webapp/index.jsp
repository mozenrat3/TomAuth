<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Start Page</title>
</head>
<body>
<%--<p><input type="submit" value="Авторизация"--%>
<%--          onclick="<c:redirect url="/login" />" />--%>
<%--    <br />--%>
<%--</p>--%>
<c:if test="${val == null}">
    <c:redirect url="/login" />
</c:if>
</body>
</html>