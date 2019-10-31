package com.example.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {

    private ArrayList<String> list = new ArrayList<>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest reqProxy = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
                req.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.getName().equals("getParameter")) {
                            String value = (String) method.invoke(req, args);

                            for (String str : list) {
                                value = value.replaceAll(str, "***");
                            }

                            return value;
                        } else {
                            return method.invoke(req, args);
                        }
                    }
                });
        chain.doFilter(reqProxy, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        BufferedReader reader = null;
        try {
            InputStream is = config.getServletContext().getResourceAsStream("/WEB-INF/classes/敏感词汇.txt");
            reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String line = null;
            while ((line = reader.readLine()) != null) {
                list.add(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
