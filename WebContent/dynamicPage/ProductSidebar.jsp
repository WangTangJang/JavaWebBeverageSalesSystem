<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/6/17
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<ul>
    <dl>
        <c:forEach items="${listCategroy}" var="c1">
            <dt>${c1.name}</dt>
            <c:forEach items="${c1.secondCategroy}" var="c2">
                <dd>
                    <a href="ProductServlet?op=findProductByPage&categoryId=${c2.id}">${c2.name}</a>
                </dd>
            </c:forEach>
        </c:forEach>
    </dl>
</ul>