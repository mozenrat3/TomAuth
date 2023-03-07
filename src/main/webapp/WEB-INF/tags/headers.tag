<%@ tag import="java.util.Objects" %>
<%@ tag import="com.example.testapp.model.User" %>
<%@ tag description="headertag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" />
<style>
    header {
        background: antiquewhite no-repeat;
    }
</style>
<header>
    <div style="float:left">
        <h1>
            <picture>
                <img src="${pageContext.request.contextPath}/img/V7f9sTgB5gM.webp" alt="logo" width="110px"
                     height="100%"/>
            </picture>
        </h1>
    </div>
    <div style="float: right; padding: 40px; text-align: right;">

        Hello <b>${user.login}</b>. <a href="<c:url value='/logout' />">Logout</a>
        <br/>
    </div>
</header>

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">
    <div style="margin: auto; padding: 10px">
        <a href="<c:url value="/welcome"/>">Main Page</a>
        <%
            User.ROLE role = (User.ROLE) request.getSession().getAttribute("role");
        if(role== User.ROLE.ADMIN) {
            %>
        |
        <a href="<c:url value="/userinfo"/>">User Info</a>
    <%
        }
        %>
<%--        <a href="<c:url value="/userinfo"/>">User Info</a>--%>
    </div>
</nav>
