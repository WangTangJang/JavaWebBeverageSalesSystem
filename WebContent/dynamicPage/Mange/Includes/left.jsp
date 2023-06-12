<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<dl>
    <dt>甜品</dt>
    <dd>
        <em><a href="DessertServlet?op=findDessertByPage">甜品管理</a></em>
        <em><a href="DessertServlet?op=toAddPage">新增甜品</a></em>
        <em><a href="DessertServlet?op=findAll">全部甜品</a></em>
    </dd>
    <form action="DessertServlet?op=findDessertByPage" method="post">
        <label for="search">搜索甜品:</label>
        <input type="text" id="search" name="keyword" value="${keyword}">
        <label for="property">搜索属性:</label>
        <select id="property" name="property">
            <option value="name" <c:if test="${property=='name'}">selected='selected'</c:if>>甜品名称</option>
            <option value="type" <c:if test="${property=='type'}">selected='selected'</c:if>>甜品类型</option>
            <option value="manufacturer" <c:if test="${property=='manufacturer'}">selected='selected'</c:if>>生产厂商</option>
        </select>
        <input type="submit" value="搜索">
    </form>
</dl>