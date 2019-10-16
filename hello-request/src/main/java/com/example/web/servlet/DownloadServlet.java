package com.example.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取请求连接中的文件名
        String filename = req.getParameter("filename");
        // 2.获取文件的真实位置
        ServletContext servletContext = this.getServletContext();
        String filePath = servletContext.getRealPath("/image/" + filename);
        // 3.设置响应头
        String mimeType = servletContext.getMimeType(filename);
        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        // 4.将文件写到输出流
        FileInputStream fis = new FileInputStream(filePath);
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] b = new byte[8 * 1024];
        int len = 0;
        while((len = fis.read(b)) > 0) {
            outputStream.write(b);
        }
        fis.close();
    }
}
