<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/useradd.css" rel="stylesheet" type="text/css">

    <title>User add</title>
</head>
<body>
<header>
    <jsp:include page="header.jsp"></jsp:include>
</header>
<div id="menu">
    <jsp:include page="menu.jsp"></jsp:include>
</div>


<main>
    <div id="myform">
        <div id="formname"><h2>user add</h2></div>
        <form method="post" action="">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="number" name="id" placeholder="Enter id" required></td>
                </tr>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" placeholder="Enter  login" minlength="5" maxlength="16"
                               required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter  password"
                               pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                               autocomplete="off" required></td>
                </tr>

                <tr>
                    <td>email</td>
                    <td><input type="email" name="email" placeholder="Enter  email"
                               pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" size="30" required></td>
                </tr>
                <tr>
                    <td>surname</td>
                    <td><input type="text" name="surname" placeholder="Enter surname" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" placeholder="Enter name" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr>
                    <td>patronymic</td>
                    <td><input type="text" name="patronymic" placeholder="Enter patronymic"
                               pattern="[A-Za-zА-Яа-яЁё]{3,15}" required></td>
                </tr>
                <tr>
                    <td>birthday</td>
                    <td><input type="date" name="birthday" required></td>
                </tr>
                <tr>
                    <td>role</td>
                    <td>
                        <input type="radio" name="role1" value="user"> USER<br>
                        <input type="radio" name="role2" value="admin"> ADMIN<br>
                        <%--                    <td><input type="text" name="role" placeholder="Enter role" pattern="[USER/ROLE]" required></td>--%>
                    </td>

                </tr>
                <tr>
                    <td colspan="1">

                        <input type="submit" value="Submit">
                    </td>
                </tr>

            </table>


        </form>
    </div>
</main>
</body>
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>


</html>
