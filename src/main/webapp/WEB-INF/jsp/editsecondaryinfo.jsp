<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page import="static com.example.testapp.model.User.ROLE.USER" %>
<%@ page import="com.example.testapp.servlet.EditSecInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/css/useredit.css" rel="stylesheet" type="text/css">

    <title>User add</title>
</head>
<body>
<t:headers></t:headers>


<main>
    <div id="myform">
        <div id="formname"><h2>user edit</h2></div>
        <form method="post" action="">
            <table>
                <%
                    String userId = request.getParameter("userId");
                    User user = UserOperations.getById(Integer.parseInt(userId));
                    String email = user.getEmail();
                    String surname = user.getSurname();
                    String name = user.getName();
                    String patronymic = user.getPatronymic();
                    String birthday = user.getBirthday();
                    User.ROLE role = user.getRole();
                %>
                <tr>
                    <td>email</td>
                    <td><input type="email" name="email"
                               value=<%=email%> pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" size="30" required>
                    </td>
                </tr>
                <tr>
                    <td>surname</td>
                    <td><input type="text" name="surname" value="<%=surname%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr>
                    <td>name</td>
                    <td><input type="text" name="name" value="<%=name%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}" required></td>
                </tr>
                <tr>
                    <td>patronymic</td>
                    <td><input type="text" name="patronymic" value="<%=patronymic%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr>
                    <td>birthday</td>
                    <td><input type="date" name="birthday" value="<%=birthday%>" required></td>
                </tr>
                <tr>
                    <td>role</td>
                    <td>
                        <input type="radio" name="role" id="role1" value="user" > USER<br>
                        <input type="radio" name="role" id="role2" value="admin"> ADMIN<br>
                        <%--                    <td><input type="text" name="role" placeholder="Enter role" pattern="[USER/ROLE]" required></td>--%>
                    </td>

                </tr>
                <div id="error">
                    <%
                        String secedit_msg=(String)request.getAttribute("error");
                        if(secedit_msg!=null)
                            out.println("<font color=red size=4px>"+secedit_msg+"</font>");
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
<t:footers></t:footers>


</html>
