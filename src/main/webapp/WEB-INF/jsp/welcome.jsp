<%@ page import="java.util.List" %>
<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="users" class="com.example.testapp.model.User" scope="page"/>
<jsp:useBean id="userop" class="com.example.testapp.model.UserOperations" scope="page"/>
<jsp:useBean id="mda" class="com.example.testapp.servlet.FakeData" scope="page"/>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/welcome.css" rel="stylesheet" type="text/css">
    <title>Welcome</title>
</head>
<body>
<t:headers>

</t:headers>
<main>
    <h3>Hello is this a main page</h3>
    <br>
    <table border="1" cellspacing="0" cellpadding="2">
        <tr>
            <td>id</td>
            <td>Login</td>
            <td>Password</td>
            <td>Email</td>
            <td>Surname</td>
            <td>Name</td>
            <td>Patronymic</td>
            <td>Birthday</td>
            <td>Role</td>
        </tr>


        <c:set value="<%=UserOperations.getAllUsers()%>" var="userss"/>
        <c:forEach items="${userss}" var="user">
            <tr>

                <td><c:out value="${user.id}"/></td>
                <c:set var="uid"  value="${user.id}"/>
                <c:choose>
                    <c:when test="${uid >= 3  && uid <5}">
                        <c:if test="${uid==4}">
                            <td><c:out value="${user.role}"/></td>
                            <c:set var="birthday" value="${LocalDate.parse(user.birthday)}"/>
                            <fmt:parseDate value="${birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                            <fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="parsebirthday"/>
                            <td><c:out value="${parsebirthday}"/></td>
                            <td><c:out value="${user.patronymic}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <td><c:out value="${user.login}"/> <c:out value="part"/></td>
                        </c:if>
                        <c:if test="${uid!=4}">
                            <td><c:out value="${user.role}"/></td>
                            <c:set var="birthday" value="${LocalDate.parse(user.birthday)}"/>
                            <fmt:parseDate value="${birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                            <fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="parsebirthday"/>
                            <td><c:out value="${parsebirthday}"/></td>
                            <td><c:out value="${user.patronymic}"/></td>
                            <td><c:out value="${user.name}"/></td>
                            <td><c:out value="${user.surname}"/></td>
                            <td><c:out value="${user.email}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <td><c:out value="${user.login}"/></td>
                        </c:if>

                    </c:when>
                    <c:when test="${uid >= 5}">
                       <td> <strong><c:out value="${user.login}"/></strong></td>
                        <td><strong><c:out value="${user.password}"/></strong></td>
                        <td><strong><c:out value="${user.email}"/></strong></td>
                        <td><strong><c:out value="${user.surname}"/></strong></td>
                        <td><strong><c:out value="${user.name}"/></strong></td>
                        <td><strong><c:out value="${user.patronymic}"/></strong></td>
                        <c:set var="birthday" value="${LocalDate.parse(user.birthday)}"/>
                        <fmt:parseDate value="${birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                        <fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="parsebirthday"/>
                        <td><strong><c:out value="${parsebirthday}"/></strong></td>
                        <td><strong><c:out value="${user.role}"/></strong></td>

                    </c:when>
                    <c:otherwise>
                        <td><c:out value="${user.login}"/></td>
                        <td><c:out value="${user.password}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.surname}"/></td>
                        <td><c:out value="${user.name}"/></td>
                        <td><c:out value="${user.patronymic}"/></td>
                        <c:set var="birthday" value="${LocalDate.parse(user.birthday)}"/>
                        <fmt:parseDate value="${birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
                        <fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="parsebirthday"/>
                        <td><c:out value="${parsebirthday}"/></td>
                        <td><c:out value="${user.role}"/></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </table>


</main>

</body>
<t:footers></t:footers>
</html>
