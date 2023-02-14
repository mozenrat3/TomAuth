<%@ page import="com.example.testapp.model.User" %>
<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="static com.example.testapp.model.UserOperations.getAllUsers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/userinfo.css" rel="stylesheet" type="text/css">
    <title>User Info</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div id="menu">
    <jsp:include page="menu.jsp"></jsp:include>
</div>
<div id = "userCrud">
    <div id="refs">
        <a href="${pageContext.request.contextPath}/useredit">User Edit</a>
        |
        <a href="${pageContext.request.contextPath}/useradd">User Add</a>
        |
        <a href="${pageContext.request.contextPath}/userdelete">User Delete</a>
    </div>

</div>
<main>

    <table>

        <tr>
            <th>login</th>
            <th>password</th>
            <th>email</th>
            <th>surname</th>
            <th>name</th>
            <th>patronymic</th>
            <th>birthday</th>
            <th>role</th>
        </tr>
        <%--Мб создать юзер лист в котором будем юзеров по id получать и потом выводить их--%>
        <%

            for (User user : getAllUsers()) {
                String login = user.getLogin();
                String password = user.getPassword();
                String email = user.getEmail();
                String surname = user.getSurname();
                String name = user.getName();
                String patronymic = user.getPatronymic();
                String birthday = user.getBirthday();
                User.ROLE role = user.getRole();
                out.println("<tr><td>" + login + "</td><td>" + password + "</td><td>" + email + "</td><td>" + surname + "</td><td>" + name + "</td><td>"
                        + patronymic + "</td><td>" + birthday + "</td><td>" + role + "</tr>");
            }
        %>
    </table>
</main>

</body>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>

</html>
