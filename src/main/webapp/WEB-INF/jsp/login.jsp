<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet" type="text/css">
    <title>Sign In</title>
</head>

<body>
<t:headers >
</t:headers>
<main>
    <div id="myform">
        <div id="formname"><h1>Sign in</h1></div>
        <form method="post" action="">
            <table>
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" placeholder="Enter your login" minlength="5" maxlength="16" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter your password" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                               autocomplete="off" required></td>
                </tr>
                <div id="error">
                    <%
                        String login_msg=(String)request.getAttribute("error");
                        if(login_msg!=null)
                            out.println("<font color=red size=4px>"+login_msg+"</font>");
                    %>
                </div>
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
<t:footers >
</t:footers>
</html>

