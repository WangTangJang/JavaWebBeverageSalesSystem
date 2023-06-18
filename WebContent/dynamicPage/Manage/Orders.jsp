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
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/AllList.css">
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
    <div class="manage">
        订单管理
        <table class="list">
            <tr>
                <th>订单ID</th>
                <th>用户ID</th>
                <th>用户名</th>
                <th>用户地址</th>
                <th>创建时间</th>
                <th>总费用</th>
                <th>序列号</th>
            </tr>
            <c:forEach items="${requestScope.list}" var="n" varStatus="i">
                <tr>
                    <td>${n.id}</td>
                    <td>${n.userId}</td>
                    <td>${n.loginName}</td>
                    <td>${n.userAddress}</td>
                    <td>${n.createTime}</td>
                    <td>${n.cost}</td>
                    <td>${n.serialNumber}</td>
                    <td class="w1 c"><a href="orderServlet?op=findUserById&id=${n.id}">修改</a> <a
                            class="manageDel2" href="orderServlet?op=delOrder&id=${n.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
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