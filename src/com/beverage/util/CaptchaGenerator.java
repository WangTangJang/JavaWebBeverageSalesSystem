package com.beverage.util;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
@WebServlet("/CaptchaGenerator")
public class CaptchaGenerator extends HttpServlet {
    private static final int WIDTH = 200;
    private static final int HEIGHT = 80;
    private static final int CODE_LENGTH = 4;
    private static String captchaCode;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage image = generateCaptcha();
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("captchaCode", captchaCode);
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
    public static BufferedImage generateCaptcha() {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        // 设置背景色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        // 生成随机验证码
        captchaCode = generateRandomCode(CODE_LENGTH);

        // 绘制验证码
        graphics.setFont(new Font("Arial", Font.BOLD, 40));
        for (int i = 0; i < CODE_LENGTH; i++) {
            int x = i * WIDTH / CODE_LENGTH + 20;
            int y = HEIGHT / 2 + 10;
            graphics.setColor(getRandomColor());
            graphics.drawString(String.valueOf(captchaCode.charAt(i)), x, y);
        }
        // 添加干扰线
        graphics.setStroke(new BasicStroke(2));
        for (int i = 0; i < 5; i++) {
            graphics.setColor(getRandomColor());
            int x1 = getRandomNumber(0, WIDTH);
            int y1 = getRandomNumber(0, HEIGHT);
            int x2 = getRandomNumber(0, WIDTH);
            int y2 = getRandomNumber(0, HEIGHT);
            graphics.drawLine(x1, y1, x2, y2);
        }
        graphics.dispose();
        return image;
    }

    private static String generateRandomCode(int length) {
        String chars = "0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            code.append(chars.charAt(index));
        }

        return code.toString();
    }

    private static Color getRandomColor() {
        Random random = new Random();
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    private static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
