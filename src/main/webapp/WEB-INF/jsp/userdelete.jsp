<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="<c:url value="/css/userdelete.css"/>" rel="stylesheet" type="text/css">

    <title>User delete</title>
</head>
<t:cssblock></t:cssblock>
<body>
<t:headers></t:headers>
<main>
    <div class="deleteBox">
        <h3>User Delete</h3>
        <form method="post" action="">
            <div class="inputBox"><input type="text" name="login" placeholder="Enter login to delete" id="uname"
                                         minlength="5" maxlength="16" required>
            </div>
            <input type="submit" name="" value="Delete">
        </form>
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
<t:footers></t:footers>


</html>
