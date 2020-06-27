package com.servlet.student;

import com.dao.stuOperater;
import com.entity.student;

import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "stuRegister",urlPatterns = "/stuRegister")
public class stuRegister extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String name=request.getParameter("stuname");
            System.out.println(name+"欢迎你");
            //response.sendRedirect("index.jsp");
           // String name = request.getParameter("name"); //获取jsp页面传过来的参数
            String id = request.getParameter("stuid");
            String sex = request.getParameter("sex");
        String pwd=request.getParameter("stupwd");
        student user = new student(); //实例化一个对象，组装属性
        user.setSname(name);
        user.setSid(id);
        user.setPassword(pwd);
        user.setCredit(100);
        user.setSex(sex);

       stuOperater ud = new stuOperater();

        if(ud.register(user)){
            //request.setAttribute("name", name);  //向request域中放置参数
            request.getSession().setAttribute("xiaoxi", "注册成功");
            request.getRequestDispatcher("index.jsp").forward(request, response);  //转发到登录页面
        }else{
            String message="分类修改失败";
            request.getSession().setAttribute("xiaoxi", message);
            response.sendRedirect("index.jsp");//重定向到首页
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
