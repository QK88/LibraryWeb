package com.servlet.worker;

import com.dao.stuOperater;
import com.dao.worOperater;
import com.entity.book;
import com.entity.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "stuSearch",urlPatterns = "/stuSearch")
public class stuSearch extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sid=request.getParameter("stuid");
        worOperater ud = new worOperater();
        List<student> userAll =ud.getstu(sid);//获取所有该用户已借书目的值，传给model
        request.setAttribute("stu", userAll);
        request.getRequestDispatcher("worstuupdate2.jsp").forward(request, response);
    }
}
