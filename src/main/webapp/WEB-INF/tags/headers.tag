<%@ tag description="headertag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<html>--%>
<%--<head>--%>
<%--    <style>--%>
<%--        * {--%>
<%--            margin: 0;--%>
<%--        }--%>

<%--        html, body {--%>
<%--            height: 100%;--%>
<%--        }--%>

<%--        body {--%>
<%--            display: flex;--%>
<%--            flex-direction: column;--%>
<%--        }--%>

<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>

<div id="header">
    <div style="background: #E0E0E0; height: 80px; padding: 5px;">
        <div style="float:left">
            <h1>
                <picture>
                    <img src="${pageContext.request.contextPath}/img/V7f9sTgB5gM.webp" alt="logo" width="110px"
                         height="80px"/>

                </picture>
            </h1>
        </div>

        <div style="float: right; padding: 28px; text-align: right;">

            Hello <b>${user.login}</b>. <a href="<c:url value='/logout' />">Logout</a>
            <br/>


        </div>

    </div>
</div>
<div id="menu">
    <div style="padding: 10px; height: 40px;background:antiquewhite">
        <div style="float: bottom; padding: 14px; text-align: center;">
//c:url
            <a href="${pageContext.request.contextPath}/login">Sign In</a>
            |
            <a href="${pageContext.request.contextPath}/welcome">Main Page</a>
            |
            <a href="${pageContext.request.contextPath}/userinfo">User Info</a>

        </div>

    </div>
</div>


<%--</body>--%>
<%--</html>--%>