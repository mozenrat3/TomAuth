<%@ page  import="com.example.testapp.model.User" %>
<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="static com.example.testapp.model.UserOperations.getAllUsers" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<html>
<head>
    <link href="<c:url value="/css/userinfo.css"/>" rel="stylesheet" type="text/css">
    <title>User Info</title>
</head>
<t:cssblock></t:cssblock>
<body>
<t:headers></t:headers>
<div id="userCrud">
    <div id="refs">
        <a href="<c:url value="/useradd"/>">User Add</a>
        |
        <a href="<c:url value="/userdelete"/>">User Delete</a>
    </div>

</div>
<main>

    <table>

        <tr>
            <th>id</th>
            <th>login</th>
            <th>password</th>
            <th>email</th>
            <th>surname</th>
            <th>name</th>
            <th>patronymic</th>
            <th>birthday</th>
            <th>role</th>
            <th>editInfo</th>
        </tr>
        <%--Мб создать юзер лист в котором будем юзеров по id получать и потом выводить их--%>
        <%
            for (User user : getAllUsers()) {
                int id = user.getId();
                String login = user.getLogin();
                String password = user.getPassword();
                String email = user.getEmail();
                String surname = user.getSurname();
                String name = user.getName();
                String patronymic = user.getPatronymic();
                String birthday = user.getBirthday();
                User.ROLE role = user.getRole();
                out.println("<tr><td>"+id +"</td><td>"+ login + "</td><td>" + password + "</td><td>" + email + "</td><td>" + surname + "</td><td>" + name + "</td><td>"
                        + patronymic + "</td><td>" + birthday + "</td><td>" + role + "</td>"+"<td>"+"<a href="+ request.getContextPath() + "/" + "editinfo?userId=" + id+">"+
                        "EditInfo"+"</a>"+"</td></tr>");
            }
        %>
    </table>
</main>

</body>
<t:footers></t:footers>

</html>
