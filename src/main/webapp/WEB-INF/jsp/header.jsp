<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="background: #E0E0E0; height: 80px; padding: 5px;">
    <div style="float:left"
    >
        <h1>
            <picture>
              <img src="${pageContext.request.contextPath}/img/V7f9sTgB5gM.webp" alt="logo" width="110px" height="80px" />

            </picture>
        </h1>
    </div>

    <div style="float: right; padding: 28px; text-align: right;">

        Hello <b>${user.login}</b>. <a href="<c:url value='/logout' />">Logout</a>
        <br/>


    </div>

</div>
