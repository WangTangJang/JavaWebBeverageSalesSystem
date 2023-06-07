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
<div class="sidebarRight">
    <%@include file="NewsSidebar.jsp"%>
</div>
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

    <div id="shopping">
        <form id="myform" action="orderServlet?op=goOrder" method="post">
            <input type="hidden" id="size" name="size" />
            <input type="hidden" name="total" id="transferTotal"  />
            <table>
                <tr>
                    <th>商品名称</th>
                    <th>商品价格</th>
<%--                    <th>购买数量</th>--%>
                    <th>操作</th>
                </tr>
                <c:forEach items="${list}" var="s" varStatus="i">
                    <tr name="mytr" id="product_id_${i.index}">
                        <input type="hidden" name="product_id_${i.index}" value="${s.productid}" />
                        <input type="hidden" name="number_id_${i.index}" value="${s.number}" />
                        <td class="thumb"><img src="images/product/${s.fileName}" /><a
                                href="product-view.html">${s.name}</a></td>
                        <td class="price" id="price_id_${i.index}"><span>￥${s.price}</span>
                            <input type="hidden" value="${s.price} }" /></td>
<%--                        <td class="number" ><span name="del">-</span> <input--%>
<%--                                id="number_id_${i.index}" type="text" name="number_id_${i.index}"--%>
<%--                                value="${s.number}" /> <span name="add">+</span></td>--%>
                        <td class="delete"><a href="ShoppingServlet?op=delShopping&id=${s.shoppingid}">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
            <div class="total">
                <span id="total">总计：￥0</span>
            </div>
            <div class="button">
                <input type="button" onclick="doSubmit()"  value="生成订单" >
            </div>
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

<script type="text/javascript">
    function calculateTotal() {
        var total = 0;
        var rows = document.getElementsByName("mytr");
        for (var i = 0; i < rows.length; i++) {
            var priceElement = document.getElementById("price_id_" + i);

            var price = parseFloat(priceElement.innerText.replace("￥", ""));
            total += price;
        }
        var totalElement = document.getElementById("total");
        document.getElementById("transferTotal").value = total;
        totalElement.innerText = "总计：￥" + total.toFixed(2);
    }
    function doSubmit() {
        var mytr = document.getElementsByName("mytr");
        document.getElementById('size').value = mytr.length;
        document.getElementById('myform').submit();
    }
    // 调用 calculateTotal() 函数来计算总价
    calculateTotal();
</script>
</body>
</html>