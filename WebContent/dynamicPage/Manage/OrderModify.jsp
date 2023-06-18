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
    <h2>修改订单</h2>
    <div class="manage">
        <form action="/BeverageSalesSystem/orderServlet?op=modifyUser" method="post">
            <input type="hidden" name="id"  value="${user.id}"/>
            <table class="form">
                <tr>
                    <td class="field">订单ID：</td>
                    <td><input type="text" class="id" name="id" value="${user.id}" /></td>
                </tr>
                <tr>
                    <td class="field">用户ID：</td>
                    <td><input type="text" class="userId" name="userId" value="${user.userId}" /></td>
                </tr>
                <tr>
                    <td class="field">用户名：</td>
                    <td><input type="text" class="loginName" name="loginName" value="${user.loginName}" /></td>
                </tr>
                <tr>
                    <td class="field">用户地址：</td>
                    <td><input type="text" class="userAddress" name="userAddress" value="${user.userAddress}" /></td>
                </tr>
                <tr>
                    <td class="field">创建时间：</td>
                    <td><input type="text" class="createTime" name="createTime" value="${user.createTime}" /></td>
                </tr>
                <tr>
                    <td class="field">总费用：</td>
                    <td><input type="text" class="cost" name="cost" value="${user.cost}" /></td>
                </tr>
                <tr>
                    <td class="field">序列号：</td>
                    <td><input type="text" class="serialNumber" name="serialNumber" value="${user.serialNumber}" /></td>
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