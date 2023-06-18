package com.beverage.test;

import com.beverage.util.CaptchaGenerator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class CaptchaGeneratorTest {
    public static void main(String[] args) {
        try {
            CaptchaGenerator generator = new CaptchaGenerator();
            BufferedImage captchaImage = generator.generateCaptcha();

            // 将验证码图片保存为文件
            File output = new File("captcha.png");
            ImageIO.write(captchaImage, "png", output);
         } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
