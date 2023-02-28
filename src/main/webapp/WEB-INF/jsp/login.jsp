<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js" />

    <link href="<c:url value="/css/login.css"/>" rel="stylesheet" type="text/css">
    <title>Sign In</title>
</head>
<t:cssblock></t:cssblock>
<body>
<main>
    <div class="loginBox"><img class="user" src="https://i.ibb.co/yVGxFPR/2.png" height="100px" width="100px">
        <h3>Sign in</h3>
        <form method="post" action="">
            <div class="inputBox"><input type="text" name="login" placeholder="Enter your login" id="uname"
                                         minlength="5" maxlength="16" required>
                <input type="password" name="password" placeholder="Enter your password" id="pass"
                       pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*" autocomplete="off" required>
            </div>
            <input type="submit" name="" value="Login">
        </form>
        <a href="#">Forget Password<br> </a>
        <div class="text-center">
            <p style="color: #59238F;">Sign-Up</p>
        </div>
        <br>
        <div id="error">
            <%
                String login_msg=(String)request.getAttribute("error");
                if(login_msg!=null)
                    out.println("<font color=red size=4px>"+login_msg+"</font>");
            %>
        </div>
    </div>
</main>
</body>
<t:footers>
</t:footers>
</html>

