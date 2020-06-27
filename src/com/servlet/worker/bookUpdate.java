package com.servlet.worker;

import com.dao.worOperater;
import com.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookUpdate",urlPatterns = "/bookUpdate")
public class bookUpdate extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        book user=new book();
        user.setBid(request.getParameter("bid"));
        user.setPublisher(request.getParameter("publisher"));
        user.setType(request.getParameter("type"));
        user.setAuthor(request.getParameter("author"));
        user.setBname(request.getParameter("bname"));
        user.setBid(request.getParameter("bid"));
        user.setBposition(request.getParameter("position"));
        worOperater ud = new worOperater();

        if(ud.update(user)){
            request.getSession().setAttribute("xiaoxi", "更新成功");
            request.getRequestDispatcher("worbooklist.jsp").forward(request, response);
        }else{
            request.getSession().setAttribute("xiaoxi","更新失败");
            response.sendRedirect("worbooklist.jsp");
        }
    }

}
