package com.beverage.servlet;

import com.beverage.dao.impl.ProductDAOImpl;
import com.beverage.model.News;
import com.beverage.model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * 引入产品业务逻辑层
     */
    ProductDAOImpl productDAO = new ProductDAOImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }
    protected void addProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String categoryLevel1Id = request.getParameter("categoryLevel1Id");
        String categoryLevel2Id = request.getParameter("categoryLevel2Id");
        String fileName = request.getParameter("fileName");
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Float.parseFloat(price));
        product.setStock(Integer.parseInt(stock));
        product.setCategoryLevel1Id(Integer.parseInt(categoryLevel1Id));
        product.setCategoryLevel2Id(Integer.parseInt(categoryLevel2Id));
        int isDelete = 0;
        int categoryLevel3Id = 0;
        product.setCategoryLevel3Id(categoryLevel3Id);
        product.setFileName(fileName);
        product.setIsDelete(isDelete);
        try {
            int r = productDAO.addProduct(product);
            if (r > 0) {
                out.print("<script>alert('保存成功');location.href='ProductServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('保存失败');location.href='ProductServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void modifyProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String stock = request.getParameter("stock");
        String categoryLevel1Id = request.getParameter("categoryLevel1Id");
        String categoryLevel2Id = request.getParameter("categoryLevel2Id");
        String fileName = request.getParameter("fileName");
        int isDelete = 0;
        int categoryLevel3Id = 0;

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(Float.parseFloat(price));
        product.setStock(Integer.parseInt(stock));
        product.setCategoryLevel1Id(Integer.parseInt(categoryLevel1Id));
        product.setCategoryLevel2Id(Integer.parseInt(categoryLevel2Id));
        product.setCategoryLevel3Id(categoryLevel3Id);
        product.setFileName(fileName);
        product.setIsDelete(isDelete);
        product.setId(Integer.parseInt(id));
        try {
            int r = productDAO.modifyProduct(product);
            if (r > 0) {
                out.print("<script>alert('修改成功');location.href='ProductServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('修改失败');location.href='ProductServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void delProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String idString = request.getParameter("id");
        try {
            int r = productDAO.delProduct(Integer.parseInt(idString));
            if (r > 0) {
                out.print("<script>alert('删除成功');location.href='ProductServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('删除失败');location.href='ProductServlet?op=findAll';</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('删除失败');location.href='ProductServlet?op=findAll';</script>");
        }
    }
    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Product> list = productDAO.findAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("dynamicPage/Mange/Products.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        /**
         * 商品详情
         *
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    protected void productview(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        try {
            Product ep = productDAO.findProductById(Integer.parseInt(id));

            request.setAttribute("ep", ep);
            request.getRequestDispatcher("dynamicPage/ProductView.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void findProductById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            Product product = productDAO.findProductById(Integer.parseInt(id));
            request.setAttribute("product", product);
            request.getRequestDispatcher("/dynamicPage/Mange/ProductModify.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void findCategory(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("categoryId");
        try {
            List<Product> listProduct = productDAO.findProductByCategory(Integer.parseInt(id));

            request.setAttribute("listProduct", listProduct);

            request.getRequestDispatcher("dynamicPage/ProductList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String opString = request.getParameter("op");
        switch (opString) {
            case "productview":
                productview(request, response);
                break;
            case "findCategory":
                findCategory(request, response);
                break;
            case "addProduct":
                addProduct(request, response);
                break;
            case "modifyProduct":
                modifyProduct(request, response);
                break;
            case "delProduct":
                delProduct(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "findProductById":
                findProductById(request, response);
                break;
        }

    }

}
