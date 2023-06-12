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
    <title>销售系统-后台</title>
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
    <div class="main">
        <div class="manage">
            <form id="newsAdd" method="post" action="DessertServlet?op=addDessert">
                <table class="form">
                    <tr>
                        <td class="field">甜品名称：</td>
                        <td><input type="text" class="name" name="name" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">甜品类型：</td>
                        <td><input type="text" class="type" name="type" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">生产厂商：</td>
                        <td><input type="text" class="manufacturer" name="manufacturer" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">生产日期：</td>
                        <td><input type="text" class="productionDate" name="productionDate" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">生产地址：</td>
                        <td><input type="text" class="productionAdd" name="productionAdd" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">甜品价格：</td>
                        <td><input type="text" class="price" name="price" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td class="field">甜品库存：</td>
                        <td><input type="text" class="stock" name="stock" value="" /><span></span></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="submit" value="添加" /></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<footer class="footer">
    <%@include file="Includes/footer.jsp"%>
</footer>
<!-- JavaScript 动画效果 -->
<script type="text/javascript" src="<%= request.getContextPath() %>/JavaScript/Index.js"></script>
</body>
</html>