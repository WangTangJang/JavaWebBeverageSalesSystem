<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<dl>
    <dt>用户信息</dt>
    <dd><em><a href="/BeverageSalesSystem/dynamicPage/Register.jsp">新增</a></em><a href="/BeverageSalesSystem/UserServlet?op=findAll">用户管理</a></dd>
    <dt>商品信息</dt>
    <dd><em><a href="/BeverageSalesSystem/dynamicPage/Mange/ProductsAdd.jsp">新增</a></em><a href="/BeverageSalesSystem/ProductServlet?op=findAll">商品管理</a></dd>
    <dt>订单信息</dt>
    <dd><a href="/BeverageSalesSystem/orderServlet?op=findAll">订单管理</a></dd>
    <dt>新闻信息</dt>
    <dd><em><a href="/BeverageSalesSystem/dynamicPage/Mange/NewsAdd.jsp">新增</a></em><a href="/BeverageSalesSystem/NewsServlet?op=findAll">新闻管理</a></dd>
</dl>