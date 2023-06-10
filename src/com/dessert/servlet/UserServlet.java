package com.dessert.servlet;
import com.dessert.dao.impl.UserDAOImpl;
import com.dessert.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    /**
     * 引用用户业务逻辑层
     */
    UserDAOImpl userDao = new UserDAOImpl();

    /**
     * 登录
     *
     * @param request 请求
     * @param response 回复
     */
    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String loginName = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            User user = userDao.login(loginName, password);
            if (user == null) {
                request.getSession().setAttribute("ERROR", "Error:用户名或者密码错误");
                response.sendRedirect("LoginServlet");
            } else {
                request.getSession().setAttribute("USERS", user);
                response.sendRedirect("DessertServlet?op=findAll");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 注册
     *
     * @param request 请求
     * @param response 回复
     */
    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        try {
            int r = userDao.register(user);
            if (r > 0) {
                PrintWriter out = response.getWriter();
                out.println("<script>alert('success');location.href='LoginServlet';</script>");
            } else {
                request.getSession().setAttribute("ERROR", "注册失败");
                response.sendRedirect("RegisterServlet");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 注销
     * @param request 请求
     * @param response 回复
     */
    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().invalidate();
        response.sendRedirect("LoginServlet");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //接收地址栏的op参数
        String op = request.getParameter("op");
        switch (op) {
            case "login" -> login(request, response);
            case "register" -> register(request, response);
            case "logout" -> logout(request, response);
        }
    }
}
