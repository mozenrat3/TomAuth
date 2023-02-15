<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/userdelete.css" rel="stylesheet" type="text/css">

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
        <div id="formname"><h2>user delete</h2></div>
        <form method="post" action="">
            <table>

                <tr>
                    <td>Login</td>
                    <td><input type="text" name="login" placeholder="Enter  login" required></td>
                </tr>
                <div id="error">
                    <%
                        String delete_msg=(String)request.getAttribute("error");
                        if(delete_msg!=null)
                            out.println("<font color=red size=4px>"+delete_msg+"</font>");
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
<footer>
    <jsp:include page="footer.jsp"></jsp:include>
</footer>


</html>
