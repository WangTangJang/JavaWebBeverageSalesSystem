
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="announcement">
    <ul>
        <c:forEach items="${requestScope.listNews}" var="n" end="8">
            <li><a href="NewsServlet?op=newsView&id=${n.id}"
                   target="_self">${n.title}</a></li>
        </c:forEach>
    </ul>
</div>
<ul>
    <!-- 侧边栏菜单项 -->
</ul>
