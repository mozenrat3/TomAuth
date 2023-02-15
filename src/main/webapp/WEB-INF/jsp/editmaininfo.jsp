<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page import="com.example.testapp.model.User" %>
<%@ page import="static com.example.testapp.model.User.ROLE.USER" %>
<%@ page import="com.example.testapp.servlet.EditSecInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="${pageContext.request.contextPath}/css/useredit2.css" rel="stylesheet" type="text/css">

  <title>Edit Main Info</title>
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
    <div id="formname"><h2>user edit</h2></div>
    <form method="post" action="">
      <table>
        <%
          String userId = request.getParameter("userId");
          User user = UserOperations.getById(Integer.parseInt(userId));
          String login = user.getLogin();
          String password = user.getPassword();
        %>
        <tr>
          <td>Login</td>
          <td><input type="text" name="login" value="<%=login%>" minlength="5" maxlength="16" required></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="text" name="password" value="<%=password%>" required></td>
        </tr>
        <tr>
          <td>NewPassword</td>
          <td><input type="password" name="newpassword"
                     pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                     autocomplete="off" required></td>
        </tr>
        <tr>
          <td>ConfirmPassword</td>
          <td><input type="password" name="confirmpassword"
                     pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*"
                     autocomplete="off" required></td>
        </tr>
        <div id="error">
          <%
            String mainedit_msg=(String)request.getAttribute("error");
            if(mainedit_msg!=null)
              out.println("<font color=red size=4px>"+mainedit_msg+"</font>");
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
