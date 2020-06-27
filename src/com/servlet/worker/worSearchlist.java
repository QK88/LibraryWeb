package com.servlet.worker;

import com.dao.worOperater;
import com.entity.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "worSearchlist",urlPatterns = "/worSearchlist")
public class worSearchlist extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        book user=new book();
        user.setType(request.getParameter("booktype"));
        user.setPublisher(request.getParameter("publisher"));
        user.setBname(request.getParameter("name"));
        user.setAuthor(request.getParameter("author"));
        worOperater ud = new worOperater();
        List<book> userAll = ud.getbookAll(user);//获取所有该用户已借书目的值，传给model
        request.setAttribute("userAll", userAll);
        request.getRequestDispatcher("worbooklist.jsp").forward(request, response);
    }
}
