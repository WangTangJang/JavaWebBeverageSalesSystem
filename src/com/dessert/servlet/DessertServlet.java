package com.dessert.servlet;

import com.dessert.model.Dessert;
import com.dessert.model.DessertPage;
import com.dessert.service.impl.DessertServiceDAOImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DessertServlet")
public class DessertServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 引入产品业务逻辑层
     */
    DessertServiceDAOImpl dessertDAO = new DessertServiceDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        switch (op){
            case "findAll" -> findAll(request,response);
            case "findDessertByPage" -> findDessertByPage(request,response);
            case "addDessert" ->addDessert(request,response);
            case "toAddPage" ->toAddPage(request,response);
            case "findDessertById" -> findDessertById(request,response);
            case "modifyDessert" -> modifyDessert(request,response);
            case "delDessert" ->delDessert(request,response);
        }
    }
    private void findDessertByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int currentPage =1;
        int pageSize =8;
        int totalPage = 0;
        int totalCount=0;

        String where = "";
        String  keyword = request.getParameter("keyword");
        String property = request.getParameter("property");
        if (keyword != null && !keyword.equals("")) {
            //加上按姓名筛选的SQL条件(模糊查询)
            where += " and "+property+" like '%" + keyword + "%'";
            //在request域对象中存入姓名，便于前端获取展示
            request.setAttribute("keyword", keyword);
            request.setAttribute("property", property);
        }

        // 从请求参数中获取当前页码
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            currentPage = Integer.parseInt(pageParam);
        }
        List<Dessert> dessertList = null;
        DessertPage dessertPage = null;
        try {
            dessertPage = dessertDAO.findDessertsByPage(where,currentPage, pageSize);
            dessertList = dessertPage.getDessertList();
            totalCount = dessertPage.getTotalRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算总页数
        if (totalCount % pageSize == 0) { //可以整除
            totalPage = totalCount / pageSize;
        } else { //不可以整除
            totalPage = (totalCount / pageSize) + 1;
        }
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("totalCount",totalCount);
        request.setAttribute("list", dessertList);
        request.getRequestDispatcher("dynamicPage/Mange/Index.jsp").forward(request, response);

    }
    protected void addDessert(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        String productionDate = request.getParameter("productionDate");
        String productionAdd = request.getParameter("productionAdd");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(productionDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Dessert dessert = new Dessert();
        dessert.setName(name);
        dessert.setType(type);
        dessert.setManufacturer(manufacturer);
        dessert.setProductionDate(date);
        dessert.setProductionAdd(productionAdd);
        dessert.setPrice(Float.parseFloat(price));
        dessert.setStock(Integer.parseInt(stock));
        int r = 0;
        try {
            r = dessertDAO.addDessert(dessert);
            if (r > 0){
                out.print("<script>alert('保存成功');location.href='DessertServlet?op=findAll';</script>");
            }
            else {
                out.print("<script>alert('保存失败');location.href='DessertServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void modifyDessert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String manufacturer = request.getParameter("manufacturer");
        String productionDate = request.getParameter("productionDate");
        String productionAdd = request.getParameter("productionAdd");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = dateFormat.parse(productionDate);

            Dessert dessert = new Dessert();
            dessert.setId(Integer.parseInt(id));
            dessert.setName(name);
            dessert.setType(type);
            dessert.setManufacturer(manufacturer);
            dessert.setProductionDate(date);
            dessert.setProductionAdd(productionAdd);
            dessert.setPrice(Float.parseFloat(price));
            dessert.setStock(Integer.parseInt(stock));
            int result = dessertDAO.modifyDessert(dessert);
            if (result > 0) {
                out.print("<script>alert('修改成功');location.href='DessertServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('修改失败');history.back();</script>");
            }
        } catch (ParseException e) {
            e.printStackTrace();
            out.print("<script>alert('日期格式错误');history.back();</script>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void delDessert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取要删除的 dessert 的 id
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isEmpty()) {
            out.print("<script>alert('无效的参数');location.href='DessertServlet?op=findAll';</script>");
            return;
        }
        int id = Integer.parseInt(idParam);
        try {
            // 调用 dessertDAO 的删除方法
            int result = dessertDAO.delDessert(id);
            if (result > 0) {
                out.print("<script>alert('删除成功');location.href='DessertServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('删除失败');location.href='DessertServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('删除失败');location.href='DessertServlet?op=findAll';</script>");
        }
    }
    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Dessert> list = dessertDAO.findAll();
            request.setAttribute("list",list);
            request.getRequestDispatcher("dynamicPage/Mange/DesertAll.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void Dessertview(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    protected void findDessertById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Dessert dessert = dessertDAO.findDessertById(Integer.parseInt(id));
            if (dessert != null) {
                request.setAttribute("dessert", dessert);
                request.getRequestDispatcher("dynamicPage/Mange/DessertModify.jsp").forward(request, response);
            } else {
                request.setAttribute("ERROR", "未找到该产品");
                request.getRequestDispatcher("dynamicPage/Mange/Index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("ERROR", "查询异常");
            request.getRequestDispatcher("dynamicPage/Mange/Index.jsp").forward(request, response);
        }
    }


    private void toAddPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        request.getRequestDispatcher("dynamicPage/Mange/DessertAdd.jsp").forward(request, response);
    }

}
