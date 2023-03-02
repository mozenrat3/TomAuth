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
     <link href="<c:url value="/css/welcome.css"/>" rel="stylesheet" type="text/css">
    <title>Welcome</title>
</head>
<t:cssblock></t:cssblock>
<body>
<t:headers>

</t:headers>
<main>
    <div id = "tabl">
        <h3>Hello is this a main page</h3>
        <c:set value="<%=UserOperations.getAllUsers()%>" var="userss"/>
        <c:forEach items="${userss}" var="user">
            <c:set var="birthday" value="${LocalDate.parse(user.birthday)}"/>
            <fmt:parseDate value="${birthday}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
            <fmt:formatDate value="${parsedDate}" type="date" pattern="dd.MM.yyyy" var="parsebirthday"/>
            <c:set var="uid" value="${user.id}"/>
            <c:choose>
                <c:when test="${uid >= 3  && uid <5}">
                    <c:if test="${uid==4}">
                        <c:out value="${user.role};${user.birthday};${user.patronymic};${user.name};${user.surname};${user.email};${user.password};${user.login};${user.id}половина"/>
                        <br/>
                    </c:if>
                    <c:if test="${uid!=4}">
                        <c:out value="${user.role};${user.birthday};${user.patronymic};${user.name};${user.surname};${user.email};${user.password};${user.login};${user.id}"/>
                        <br/>
                    </c:if>

                </c:when>
                <c:when test="${uid >= 5}">
                    <strong> <c:out
                            value="${user.id};${user.login};${user.password};${user.email};${user.surname};${user.name};${user.patronymic};${parsebirthday};${user.role}"/></strong>
                    <br/>
                </c:when>
                <c:otherwise>
                    <c:out value="${user.id};${user.login};${user.password};${user.email};${user.surname};${user.name};${user.patronymic};${parsebirthday};${user.role}"/>
                    <br/>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </div>



</main>

</body>
<t:footers></t:footers>
</html>
