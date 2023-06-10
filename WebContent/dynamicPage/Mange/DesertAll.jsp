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
  <%@include file="Includes/header.jsp"%>
</div>
<!-- 侧边栏 -->
<div class="sidebar">
  <%@include file="Includes/left.jsp"%>
</div>
<!-- 主要内容 -->
<div class="content">
  <div class="manage">
    甜品管理
    <table class="list">
      <tr>
        <th>ID</th>
        <th>甜品名称</th>
        <th>甜品类型</th>
        <th>生产厂商</th>
        <th>生产日期</th>
        <th>生产地址</th>
        <th>甜品价格</th>
        <th>甜品库存</th>
        <th>操作方式</th>
      </tr>
      <c:forEach items="${requestScope.list}" var="n" varStatus="i">
        <tr>
          <td>${i.index+1}</td>
          <td>${n.name}</td>
          <td>${n.type}</td>
          <td>${n.manufacturer}</td>
          <td>${n.productionDate}</td>
          <td>${n.productionAdd}</td>
          <td>${n.price}</td>
          <td>${n.stock}</td>
          <td>
            <a href="DessertServlet?op=findDessertById&id=${n.id}">修改</a>
            <a class="manageDel2" href="DessertServlet?op=delDessert&id=${n.id}">删除</a>
          </td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
<footer class="footer">
  <%@include file="Includes/footer.jsp"%>
</footer>
<!-- JavaScript 动画效果 -->
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Index.js"></script>
</body>
</html>