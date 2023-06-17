<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/6
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--加一个搜索框--%>
<form action="<%= request.getContextPath() %>/ProductServlet?op=findProductByPage" method="post">
    <input type="text" name="productName" placeholder="请输入关键字">
    <input type="submit" value="搜索">
</form>
<a href="IndexServlet">首页</a>
<a href="<%= request.getContextPath() %>/ShoppingServlet?op=showShopping">购物车</a>

<c:if test="${sessionScope.USERS eq null}">
    <a href="dynamicPage/Login.jsp">登录</a>
    <a href="dynamicPage/Register.jsp">注册</a>
</c:if>
<c:if test="${sessionScope.USERS ne null}">
    <c:choose>
        <c:when test="${sessionScope.USERS.type eq 'admin'}">
            <!-- 管理员登录后的操作 -->
            <a href="dynamicPage/Mange/Index.jsp">后台管理</a>

            <a href="#">欢迎你（管理员）：${sessionScope.USERS.username}</a>
        </c:when>
        <c:otherwise>
            <!-- 非管理员登录后的操作 -->
            欢迎你：${sessionScope.USERS.username}
        </c:otherwise>
    </c:choose>
    <a class="button" id="logout2" href="javascript:logout();">注销</a>
</c:if>
<script type="text/javascript">
    function logout() {
        if (confirm("确定要注销吗？")) {
            location.href='<%= request.getContextPath() %>/UserServlet?op=logout';
        }
    }
</script>
