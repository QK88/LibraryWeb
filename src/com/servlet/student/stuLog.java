package com.servlet.student;

import com.dao.stuOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@WebServlet(name = "stuLog",urlPatterns = "/stuLog")
public class stuLog extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("stuid"); //得到jsp页面传过来的参数
        String pwd = request.getParameter("stupwd");
        String flag = request.getParameter("isLogin");
        stuOperater ud = new stuOperater();

        if(ud.login(id,pwd)){
            if("y".equals(flag)){
            Cookie cookiestuid;
            Cookie cookiestupwd;
            try {
                cookiestuid = new Cookie("stuid", URLEncoder.encode(id, "UTF-8"));
                cookiestupwd=new Cookie("stupwd", URLEncoder.encode(pwd, "UTF-8"));
                cookiestuid.setMaxAge(60*60*24);
                cookiestupwd.setMaxAge(60*60*24);
                response.addCookie(cookiestuid);
                response.addCookie(cookiestupwd);
            } catch (UnsupportedEncodingException e) {

                e.printStackTrace();

            }
            }
            request.getSession().setAttribute("xiaoxi", "欢迎用户"+id); //向request域中放置信息
            request.getRequestDispatcher("stuborrow.jsp").forward(request, response);//转发到成功页面
        }else{
            request.getSession().setAttribute("xiaoxi","登录失败");
            response.sendRedirect("index.jsp"); //重定向到首页
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);  //将信息使用doPost方法执行   对应jsp页面中的form表单中的method

    }
}
