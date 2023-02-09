<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">

    <title>Sign in</title>
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
                    <td>Login</td>
                    <td><input type="text" name="login" placeholder="Enter your login" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter your password" required></td>
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
