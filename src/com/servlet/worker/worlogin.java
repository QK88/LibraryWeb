package com.servlet.worker;

import com.dao.worOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet(name = "worlogin",urlPatterns = "/worlogin")
public class worlogin extends HttpServlet {
    //员工登录需要继承HttpServlet  并重写doGet  doPost方法
        public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method
        }
        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            String id = request.getParameter("worid"); //得到jsp页面传过来的参数
            String pwd = request.getParameter("worpwd");

            Cookie cookie;

            try {

                cookie = new Cookie("worid", URLEncoder.encode(id, "UTF-8"));

                response.addCookie(cookie);

            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();

            }


            worOperater ud = new worOperater();

            if(ud.login(id, pwd)){
                request.getSession().setAttribute("xiaoxi", "欢迎用户"+id); //向request域中放置信息
                request.getRequestDispatcher("worOperate.jsp").forward(request, response);//转发到成功页面
            }else{
                response.sendRedirect("worlogin.jsp"); //重定向到首页
            }
        }

    }
