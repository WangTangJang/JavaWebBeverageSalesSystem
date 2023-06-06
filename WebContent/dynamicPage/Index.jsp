<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
    <meta charset="UTF-8">
    <title>饮品销售系统</title>
    <link type="text/css" rel="stylesheet" href="../CSS/Index.css" />
</head>
<body>
<!-- 导航栏 -->
<div class="navbar">
    <a href="#">首页</a>
    <a href="#">购物车</a>
    <a href="#">后台管理</a>
    <a href="dynamicPage/Login.jsp">登录</a>
    <a href="#">注销</a>
</div>
<!-- 公告栏 -->
<div class="sidebarRight">
    <div class="announcement">
        <h4>限时优惠！购买任意两杯饮品，第三杯半价！</h4>
        <div class="announcement-buttons">
            <button class="arrow-button left-button">&#8249;</button>
            <button class="arrow-button right-button">&#8250;</button>
        </div>
    </div>
    <ul>
        <!-- 侧边栏菜单项 -->
    </ul>
</div>
<!-- 侧边栏 -->
<div class="sidebar">
    <ul>
        <dl>
            <c:forEach items="${listCategroy}" var="c1">
                <dt>${c1.name}</dt>
                <c:forEach items="${c1.secondCategroy}" var="c2">
                    <dd>
                        <a
                                href="EasyBuyProductServlet?op=findCategory&categoryId=${c2.id}">${c2.name}</a>
                    </dd>
                </c:forEach>
            </c:forEach>
        </dl>
    </ul>
</div>
<!-- 主要内容 -->
<div class="content">
    <div class="drink-card">
        <img src="drink1.jpg" alt="饮品1">
        <h3>饮品1</h3>
    </div>
    <div class="drink-card">
        <img src="drink2.jpg" alt="饮品2">
        <h3>饮品2</h3>
    </div>
    <div class="drink-card">
        <img src="drink3.jpg" alt="饮品3">
        <h3>饮品3</h3>
    </div>
    <div class="drink-card">
        <img src="drink4.jpg" alt="饮品4">
        <h3>饮品4</h3>
    </div>
    <div class="drink-card">
        <img src="drink5.jpg" alt="饮品5">
        <h3>饮品5</h3>
    </div>
    <div class="drink-card">
        <img src="drink1.jpg" alt="饮品1">
        <h3>饮品1</h3>
    </div>
    <div class="drink-card">
        <img src="drink2.jpg" alt="饮品2">
        <h3>饮品2</h3>
    </div>
    <div class="drink-card">
        <img src="drink3.jpg" alt="饮品3">
        <h3>饮品3</h3>
    </div>
    <div class="drink-card">
        <img src="drink4.jpg" alt="饮品4">
        <h3>饮品4</h3>
    </div>
    <div class="drink-card">
        <img src="drink5.jpg" alt="饮品5">
        <h3>饮品5</h3>
    </div>
    <!-- 更多饮品卡片... -->
</div>

<footer class="footer">
    <div class="footer-content">
        <p>版权所有 &copy; 2023 饮品销售系统</p>
        <p>联系我们：123-456-789</p>
    </div>
</footer>
<!-- JavaScript 动画效果 -->
<script type="text/javascript" src="../JavaScript/Index.js"></script>
</body>
</html>