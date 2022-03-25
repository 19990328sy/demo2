<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2022/3/24
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isErrorPage="false" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<h1>登录界面</h1>
<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="username" > <br/>
    密码  : <input type="text" name="password"> <br>
    <input type="submit" value="登录">
</form></body>
</html>
