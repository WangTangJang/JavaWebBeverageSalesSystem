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
    <link type="text/css" rel="stylesheet" href="<%= request.getContextPath() %>/CSS/Index.css" />
</head>
<body>
<!-- 导航栏 -->
<div class="navbar">
    <%@include file="Header.jsp"%>
</div>
<!-- 公告栏 -->
<%--<div class="sidebarRight">--%>
<%--    <%@include file="NewsSidebar.jsp"%>--%>
<%--</div>--%>
<!-- 侧边栏 -->
<div class="sidebar">
    <ul>
        <dl>
            <c:forEach items="${listCategroy}" var="c1">
                <dt>${c1.name}</dt>
                <c:forEach items="${c1.secondCategroy}" var="c2">
                    <dd>
                        <a href="ProductServlet?op=findCategory&categoryId=${c2.id}">${c2.name}</a>
                    </dd>
                </c:forEach>
            </c:forEach>
        </dl>
    </ul>
</div>
<!-- 主要内容 -->
<div class="content">

    <c:forEach items="${requestScope.listProduct}" var="p" end="100">
        <div class="drink-card">
            <a href="ProductServlet?op=productview&id=${p.id}"
               target="_self">
<%--                <img src="images/product/${p.fileName}" />--%>
            </a>
            <h3>
                <a href="ProductServlet?op=productview&id=${p.id}"
                   target="_self">  ${p.name}</a>
                <ddclass="price">￥${p.price}</dd>
            </h3>
        </div>
    </c:forEach>
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