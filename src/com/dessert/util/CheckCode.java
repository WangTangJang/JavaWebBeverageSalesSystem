package com.dessert.util;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    //处理成生成验证码的GET请求
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        //创建一个BufferedImage对象,用于保存验证码，宽120，高35
        BufferedImage image = new BufferedImage(120,35,BufferedImage.TYPE_INT_RGB);
        //从image对象中获取图形对象
        Graphics g = image.getGraphics();
        //在图形对象上绘制验证码
        String scode=drawRandomNum(g);
        //获取session
        HttpSession session=request.getSession();
        //在session中存入验证码
        session.setAttribute("sCode", scode);
        //设置服务器响应的文档类型是图片
        response.setContentType("image/gif");
        //设置响应头控制浏览器不要缓存
        response.setDateHeader("expries", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        //获取响应的二进制文档流数据生成图片文件
        ImageIO.write(image, "jpg", response.getOutputStream());
    }
    //绘制4位随机生成的验证码，并返回验证码字符串
    private String drawRandomNum(Graphics g) {
        //设置画笔颜色为白色
        g.setColor(Color.WHITE);
        //绘制白色的矩形作为背景
        g.fillRect(0, 0,120, 35);
        //设置画笔颜色为红色
        g.setColor(Color.RED);
        //设置验证码的字体和字号
        g.setFont(new Font("宋体",Font.BOLD,20));
        //定义验证码所用的字符（这里只用数字）
        String code = "0123456789";

        //生成的最后的验证码
        String scode="";

        //绘制字符在水平位置的开始坐标
        int x = 8;
        //利用循环绘制4个字符
        for(int i=0;i<4;i++) {
            //从验证码所用的字符中随机获取一个字符
            String ch = code.charAt(new Random().nextInt(code.length()))+"";
            //在指定的位置绘制该字符
            g.drawString(ch, x, 25);
            //下一个字符距离上一个字符的左边是20
            x += 20;

            //把随机生成的一个字符加入验证码字符串中
            scode+=ch;
        }
        System.out.println("生成的验证码:"+scode);
        return scode;
    }
}
