<%@ page import="com.example.testapp.model.User" %>
<%@ page import="com.example.testapp.model.UserOperations" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link href="${pageContext.request.contextPath}/css/userinfo.css" rel="stylesheet" type="text/css">
  <title>User Info</title>
</head>
<body>
<header> <jsp:include page="header.jsp"></jsp:include></header>
<div id="menu">
  <jsp:include page="menu.jsp"></jsp:include>
</div>
<main>
  <table>

    <tr><th>login</th><th>password</th><th>email</th><th>surname</th><th>name</th><th>patronymic</th><th>birthday</th><th>role</th></tr>
<%--Мб создать юзер лист в котором будем юзеров по id получать и потом выводить их,вопрос как выводить--%>
    <%
       String name;
      int count = UserOperations.getCount();
      for (int i = 1; i<= count;i++){
        User user = UserOperations.getById(i);
         name = (String) user.getName();
       out.println("<tr><td>"+name+"</td><td>данные</td></tr>");
      }
    %>
    <%--<tr><td><%name%></td><td>данные</td></tr> --%>

<%--            <tr><td><%name%></td><td>данные</td></tr>;--%>
  </table>
</main>

</body>
<footer>
  <jsp:include page="footer.jsp"></jsp:include>
</footer>

</html>
