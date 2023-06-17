<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Starry Login</title>
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Login.css" />
</head>
<% String error = (String) request.getAttribute("ERROR"); %>
<% if (error != null) { %>
<script>
    alert("<%= error %>");
</script>
<% } %>
<body>
<canvas id="stars"></canvas>

<div class="login-container">
    <h1>登录</h1>
    <form method="post" action="/BeverageSalesSystem/UserServlet?op=login">
        <div class="form-group">
            <label for="username">用户名称</label>
            <input type="text" id="username" name="username" placeholder="请输入用户名" required>
        </div>
        <div class="form-group">
            <label for="password">用户密码</label>
            <input type="password" id="password" name="password" placeholder="请输入密码" required>
        </div>
        <div class="form-group">
            <input type="submit" value="登录">
            <input type="button" id="register-btn" value="去注册" onclick="goToRegisterPage()">
        </div>
    </form>
</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Star.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Login.js"></script>
</body>
</html>

