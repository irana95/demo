<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: acer
  Date: 17.07.2019
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="user" type="com.example.demo.Model.User"--%>
<form:form action="/registerUser" method="get" modelAttribute="user" >
    <input type="text" id="name" name="name" path="name">
    <br>
    <input type="text" id="surname" name="surname" path="surname">
    <br>
    <input type="text" id="username" name="username" path="username">

    <br>
    <input type="password" id="password" name="password" path="password">
    <br>
    <input type="submit" value="register">
</form:form>
</body>
</html>
