package com.servlet.worker;

import com.dao.worOperater;
import com.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "newBook",urlPatterns = "/newBook")
public class newBook extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name"); //获取jsp页面传过来的参数
        String id = request.getParameter("id");
        String position=request.getParameter("position");
        String pubisher=request.getParameter("publisher");
        String type=request.getParameter("type");
        String author=request.getParameter("author");

        book user = new book(); //实例化一个对象，组装属性
        user.setBname(name);
        user.setBid(id);
        user.setBposition(position);
        user.setPublisher(pubisher);
        user.setType(type);
        user.setAuthor(author);
        worOperater ud = new worOperater();

        if(ud.newbook(user)){
            request.setAttribute("name", name);  //向request域中放置参数
            request.getSession().setAttribute("xiaoxi", "添加成功");
            request.getRequestDispatcher("wornewbook.jsp").forward(request, response);  //转发到登录页面
        }else{
            request.getSession().setAttribute("xiaoxi","添加失败");
            response.sendRedirect("wornewbook.jsp");//重定向到首页
        }
    }

}