<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>


<c:if test="${sessionScope.USERS ne null}">
    欢迎你（管理员）：${sessionScope.USERS.username}
    <a class="button" id="logout2" href="javascript:logout();">注销</a>
</c:if>

<c:choose>
    <c:when test="${sessionScope.USERS ne null}">
        欢迎你（管理员）：${sessionScope.USERS.username}
        <a class="button" id="logout2" href="javascript:logout();">注销</a>
    </c:when>
    <c:otherwise>
        <script>
            alert("还没登录，请登录");
            window.location.href = "LoginServlet";
        </script>
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    function logout() {
        if (confirm("确定要注销吗？")) {
            location.href='UserServlet?op=logout';
        }
    }
</script>