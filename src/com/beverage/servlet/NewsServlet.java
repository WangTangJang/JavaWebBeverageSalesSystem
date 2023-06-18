package com.beverage.servlet;

import com.beverage.dao.impl.NewsDAOImpl;
import com.beverage.model.News;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewsServlet")
public class NewsServlet extends HttpServlet {

    NewsDAOImpl newsDAO = new NewsDAOImpl();

    /**
     * 添加新闻
     *
     * @param
     * @return
     * @throws Exception
     */
    protected void addNews(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String titleString = request.getParameter("title");
        String contentString = request.getParameter("content");
        News news = new News();
        news.setTitle(titleString);
        news.setContent(contentString);
        try {
            int r = newsDAO.addNews(news);
            if (r > 0) {
                out.print("<script>alert('保存成功');location.href='NewsServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('保存失败');location.href='NewsServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 修改新闻
     *
     * @param
     * @return
     * @throws Exception
     */
    protected void modifyNews(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String titleString = request.getParameter("title");
        String contentString = request.getParameter("content");
        String idString = request.getParameter("id");

        News news = new News();
        news.setTitle(titleString);
        news.setContent(contentString);
        news.setId(Integer.parseInt(idString));

        try {
            int r = newsDAO.modifyNews(news);
            if (r > 0) {
                out.print("<script>alert('修改成功');location.href='NewsServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('修改失败');location.href='NewsServlet?op=findAll';</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 删除新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    protected void delNews(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String idString = request.getParameter("id");

        try {
            int r = newsDAO.delNews(Integer.parseInt(idString));
            if (r > 0) {
                out.print("<script>alert('删除成功');location.href='NewsServlet?op=findAll';</script>");
            } else {
                out.print("<script>alert('删除失败');location.href='NewsServlet?op=findAll';</script>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.print("<script>alert('删除失败');location.href='NewsServlet?op=findAll';</script>");
        }
    }

    /**
     * 查询所有新闻
     *
     * @param en
     * @return
     * @throws Exception
     */
    protected void findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<News> list = newsDAO.findAll();
            request.setAttribute("list", list);
            request.getRequestDispatcher("dynamicPage/Manage/News.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 根据新闻ID查询新闻对象信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void findNewsById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");
        try {
            News eNews = newsDAO.findNewsById(Integer.parseInt(id));
            request.setAttribute("en", eNews);
            request.getRequestDispatcher("/dynamicPage/Manage/NewModify.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }
    /**
     * 新闻详情页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void newsView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = request.getParameter("id");

        try {
            News eNews = newsDAO.findNewsById(Integer.parseInt(id));
            request.setAttribute("en", eNews);
            request.getRequestDispatcher("dynamicPage/newView.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        switch (op) {
            case "addNews":
                addNews(request, response);
                break;
            case "modifyNews":
                modifyNews(request, response);
                break;
            case "delNews":
                delNews(request, response);
                break;
            case "findAll":
                findAll(request, response);
                break;
            case "findNewsById":
                findNewsById(request, response);
                break;
            case "newsView":
                newsView(request, response);
                break;
        }
    }
}
