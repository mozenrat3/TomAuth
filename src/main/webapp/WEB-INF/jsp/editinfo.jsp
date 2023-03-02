<%@ page import="com.example.testapp.model.UserDaoImpl" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page import="static com.example.testapp.model.User.ROLE.USER" %>
<%@ page import="com.example.testapp.servlet.EditInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <link href="<c:url value="/css/useredit.css"/>" rel="stylesheet" type="text/css">
    <title>User edit</title>
</head>
<t:cssblock></t:cssblock>
<body>
<t:headers></t:headers>
<main>
    <div id="myform">
        <form method="post" action="">
            <table class="table table-hover table-bordered table-sm table-group-divider border border-5">
                <%
                    String userId = request.getParameter("userId");
                    UserDaoImpl impl =new UserDaoImpl();
                    User user = impl.getById(Integer.parseInt(userId));
                    String login = user.getLogin();
                    String password = user.getPassword();
                    String email = user.getEmail();
                    String surname = user.getSurname();
                    String name = user.getName();
                    String patronymic = user.getPatronymic();
                    String birthday = user.getBirthday();
                    User.ROLE role = user.getRole();
                %>
                <tr class="table-light">
                    <td>Login</td>
                    <td><input type="text" name="login" value="<%=login%>" minlength="5" maxlength="16" required></td>
                </tr>
                <tr class="table-secondary">
                    <td>Password</td>
                    <td><input type="text" name="password" value="<%=password%>" required></td>
                </tr>
                <tr class="table-light">
                    <td>NewPassword</td>
                    <td><input type="password" name="newpassword"
                               pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                               autocomplete="off" required></td>
                </tr>
                <tr class="table-secondary">
                    <td>ConfirmPassword</td>
                    <td><input type="password" name="confirmpassword"
                               pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                               autocomplete="off" required></td>
                </tr>
                <tr class="table-light">
                    <td>email</td>
                    <td><input type="email" name="email"
                               value=<%=email%> pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" required>
                    </td>
                </tr>
                <tr class="table-secondary">
                    <td>surname</td>
                    <td><input type="text" name="surname" value="<%=surname%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr class="table-light">
                    <td>name</td>
                    <td><input type="text" name="name" value="<%=name%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}" required></td>
                </tr>
                <tr class="table-secondary">
                    <td>patronymic</td>
                    <td><input type="text" name="patronymic" value="<%=patronymic%>" pattern="[A-Za-zА-Яа-яЁё]{3,15}"
                               required></td>
                </tr>
                <tr class="table-light">
                    <td>birthday</td>
                    <td><input type="date" name="birthday" value="<%=birthday%>" required></td>
                </tr>
                <tr class="table-secondary">
                    <td>role</td>
                    <td>
                        <input type="radio" name="role1" id="role1" value="user" > USER
                        <input type="radio" name="role2" id="role2" value="admin"> ADMIN<br>
                        <%--                    <td><input type="text" name="role" placeholder="Enter role" pattern="[USER/ROLE]" required></td>--%>
                    </td>

                </tr>
                <tr class="table-light">
                    <td colspan="1">

                        <input type="submit" value="Edit">
                    </td>
                    <td>
                        <div id="error">
                            <%
                                String secedit_msg=(String)request.getAttribute("error");
                                if(secedit_msg!=null)
                                    out.println("<font color=red size=4px>"+secedit_msg+"</font>");
                            %>
                        </div>
                    </td>
                </tr>

            </table>


        </form>
    </div>
</main>
</body>
<t:footers></t:footers>

</html>
