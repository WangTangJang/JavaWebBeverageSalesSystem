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
    <h2>修改饮品</h2>
    <div class="manage">
        <form action="/BeverageSalesSystem/ProductServlet?op=modifyProduct" method="post">
            <input type="hidden" name="id"  value="${product.id}"/>
            <table class="form">
                <tr>
                    <td class="field">饮品名称：</td>
                    <td><input type="text" class="name" name="name" value="${product.name}" /></td>
                </tr>
                <tr>
                    <td class="field">饮品描述：</td>
                    <td><textarea name="description">${product.description}</textarea></td>
                </tr>
                <tr>
                    <td class="field">饮品价格：</td>
                    <td><input type="text" class="price" name="price" value="${product.price}" /></td>
                </tr>
                <tr>
                    <td class="field">饮品库存：</td>
                    <td><input type="text" class="stock" name="stock" value="${product.stock}" /></td>
                </tr>
                <tr>
                    <td class="field">饮品一级分类：</td>
                    <td><input type="text" class="categoryLevel1Id" name="categoryLevel1Id" value="${product.categoryLevel1Id}" /></td>
                </tr>
                <tr>
                    <td class="field">饮品二级分类：</td>
                    <td><input type="text" class="categoryLevel2Id" name="categoryLevel2Id" value="${product.categoryLevel2Id}" /></td>
                </tr>
                <tr>
                    <td class="field">饮品图片：</td>
                    <td><input type="text" class="fileName" name="fileName" value="${product.fileName}" /></td>
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