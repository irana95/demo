<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
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


<form:form action="login" method="get" >
    <input type="text" id="username" name="username" path="username">
    <br>
    <input type="password" id="password" name="password" path="password">
    <br>
    <input type="submit" value="login">
</form:form>
</body>
</html>
