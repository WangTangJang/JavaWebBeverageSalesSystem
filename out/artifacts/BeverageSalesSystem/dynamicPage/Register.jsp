<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Starry Registration</title>
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Register.css" />
</head>
<body>
<canvas id="stars"></canvas>

<div class="register-container">
    <h1>注册</h1>
    <form method="post" action="/BeverageSalesSystem/UserServlet?op=register" >
        <div class="form-group">
            <label for="username">输入昵称:</label>
            <input type="text" id="username" name="username"  required>
        </div>
        <div class="form-group">
            <label for="password">输入密码:</label>
            <input type="password" id="password"  name="password"  required>
        </div>
        <div class="form-group">
            <label for="confirm-password">确认密码:</label>
            <input type="password" id="confirm-password"  required>
        </div>
        <div class="form-group">
            <label for="email">输入邮箱:</label>
            <input type="email" id="email"  name="email"  required>
        </div>
        <div class="form-group">
            <label for="fullName">用户全称:</label>
            <input type="fullName" id="fullName"  name="fullName"  required>
        </div>
        <div class="form-group">
            <label for="address">输入地址:</label>
            <input type="address" id="address"  name="address"  required>
        </div>
        <div class="form-group">
            <label for="phoneNumber">输入手机:</label>
            <input type="phoneNumber" id="phoneNumber"  name="phoneNumber"  required>
        </div>
        <div class="form-group">
            <input type="submit" value="注册">
            <input type="button" id="login-btn" value="返回登录" onclick="goToLoginPage()">
        </div>
    </form>
</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Star.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Register.js"></script>
</body>
</html>

