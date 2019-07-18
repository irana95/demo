<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.springframework.boot.web.servlet.server.Session" %>
<%@ page import="com.example.demo.Model.EmployeeEntity" %><%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 17.07.2019
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="/logout" >Logout</a></h3>
<c:if test=" ${empty user}">
 <% response.sendRedirect("/");%>
</c:if>
Name: ${user.name} <br>
Surname: ${user.surname}   <br>
Mail: ${user.username}   <br>
Password: ${user.password}   <br>

<%--Role: ${user.role}   <br>--%>

</body>
</html>
