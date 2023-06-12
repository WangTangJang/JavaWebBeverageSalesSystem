<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <title>饮品销售系统-后台</title>
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Index.css" />
</head>
<body>
<!-- 导航栏 -->
<div class="navbar">
    <%@include file="header.jsp"%>
</div>
<!-- 侧边栏 -->
<div class="sidebar">
    <%@include file="left.jsp"%>
</div>
<!-- 主要内容 -->
<div class="content">
    <h2>修改用户</h2>
    <div class="manage">
        <form action="/BeverageSalesSystem/UserServlet?op=modifyUser" method="post">
            <input type="hidden" name="id"  value="${user.id}"/>
            <table class="form">
                <tr>
                    <td class="field">用户名称：</td>
                    <td><input type="text" class="username" name="username" value="${user.username}" /></td>
                </tr>
                <tr>
                    <td class="field">用户密码：</td>
                    <td><input type="password" class="password" name="password" value="${user.username}" /></td>
                </tr>
                <tr>
                    <td class="field">电子邮件：</td>
                    <td><input type="text" class="email" name="email" value="${user.email}" /></td>
                </tr>
                <tr>
                    <td class="field">用户全名：</td>
                    <td><input type="text" class="fullName" name="fullName" value="${user.fullName}" /></td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><input type="text" class="address" name="address" value="${user.address}" /></td>
                </tr>
                <tr>
                    <td class="field">手机号码：</td>
                    <td><input type="text" class="phoneNumber" name="phoneNumber" value="${user.phoneNumber}" /></td>
                </tr>
                <tr>
                    <td class="field">用户类型：</td>
                    <td><input type="text" class="type" name="type" value="${user.type}" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><label class="ui-blue"><input type="submit" name="submit" value="修改" /></label></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<footer class="footer">
    <div class="footer-content">
        <p>版权所有 &copy; 2023 饮品销售系统</p>
        <p>联系我们：123-456-789</p>
    </div>
</footer>
<!-- JavaScript 动画效果 -->
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Index.js"></script>
</body>
</html>