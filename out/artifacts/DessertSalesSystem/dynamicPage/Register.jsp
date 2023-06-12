<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Starry Registration</title>
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Register.css" />
</head>
<% String error = (String) request.getSession().getAttribute("ERROR"); %>
<% if (error != null) { %>
<script>
    alert("<%= error %>");
</script>
<%
        request.getSession().removeAttribute("ERROR");
    }%>
<body>
<canvas id="stars"></canvas>

<div class="register-container">
    <h1>Registration</h1>
    <form method="post" action="<%= request.getContextPath() %>/UserServlet?op=register" >
        <div class="form-group">
            <label for="username">输入昵称:</label>
            <input type="text" id="username" name="username" placeholder="输入昵称" required>
        </div>
        <div class="form-group">
            <label for="password">输入密码:</label>
            <input type="password" id="password"  name="password" placeholder="输入密码" required>
        </div>
        <div class="form-group">
            <label for="confirm-password">确认密码:</label>
            <input type="password" id="confirm-password" placeholder="确认密码" required>
        </div>
        <div class="form-group">
            <label for="email">输入邮箱:</label>
            <input type="email" id="email"  name="email" placeholder="输入邮箱号" required>
        </div>
        <div class="form-group">
            <input type="submit" value="注册">
            <input type="button" id="login-btn" value="返回登录" onclick="goToRegisterPage()">
        </div>
    </form>
</div>
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Register.js"></script>
</body>
</html>

