<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<a href="/BeverageSalesSystem/IndexServlet">返回前台</a>
<c:if test="${sessionScope.USERS ne null}">
    <c:choose>
        <c:when test="${sessionScope.USERS.type eq 'admin'}">
            <!-- 管理员登录后的操作 -->
            欢迎你（管理员）：${sessionScope.USERS.username}
        </c:when>
        <c:otherwise>
            <!-- 非管理员登录后的操作 -->

        </c:otherwise>
    </c:choose>
    <a class="button" id="logout2" href="javascript:logout();">注销</a>
</c:if>
<script type="text/javascript">
    function logout() {
        if (confirm("确定要注销吗？")) {
            location.href='/BeverageSalesSystem/UserServlet?op=logout';
        }
    }
</script>