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
    <div id = "myform">
        <div id = "formname"> <h1>Sign in</h1></div>
        <form method="post" action="">
            <table>
                <tr>
                    <td>id</td>
                    <td><input type="text" name="id" placeholder="Enter id" required></td>
                </tr>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" placeholder="Enter  login" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter  password" required></td>
                </tr>

                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" placeholder="Enter  email" required></td>
                </tr>
                <tr>
                    <td>surname</td>
                    <td><input type="text" name="surname" placeholder="Enter surname" required></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" placeholder="Enter name" required></td>
                </tr>
                <tr>
                    <td>patronymic</td>
                    <td><input type="text" name="patronymic" placeholder="Enter patronymic" required></td>
                </tr>
                <tr>
                    <td>birthday</td>
                    <td><input type="text" name="birthday" placeholder="Enter birthday" required></td>
                </tr>
                <tr>
                    <td>role</td>
                    <td><input type="text" name="role" placeholder="Enter role" required></td>
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
