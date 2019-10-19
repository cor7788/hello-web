package com.example.servlet;

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

@WebServlet("/checkCode1")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 0.获取画笔
        Graphics graphics = image.getGraphics();
        // 1.绘制外形
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width, height);
        // 2.填充颜色
        graphics.setColor(Color.pink);
        graphics.fillRect(0, 0, width, height);
        // 3.随机绘制图形
        String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            char c = str.charAt(random.nextInt(str.length()));
            sb.append(c);
            graphics.setColor(Color.blue);
            graphics.drawString(c + "", width / 5 * (i + 1), height / 2);
        }
        // 4.绘制干扰线
        for (int i = 0; i < 8; i++) {
            graphics.setColor(Color.green);
            graphics.drawLine(random.nextInt(width), random.nextInt(height),
                    random.nextInt(width), random.nextInt(height));
        }

        // 将验证码保存在 session 中
        String checkCode = sb.toString();
        HttpSession session = req.getSession();
        session.setAttribute("checkCode", checkCode);
        // 5.将图片从内存写到输出流
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }
}
