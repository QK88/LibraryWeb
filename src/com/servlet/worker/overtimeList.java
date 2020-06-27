package com.servlet.worker;

import com.dao.worOperater;
import com.entity.stuview;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "overtimeList",urlPatterns = "/overtimeList")
public class overtimeList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        worOperater ud = new worOperater();
        List<stuview> userAll = ud.getstuAll(0);//获取所有该用户已借书目的值，传给model
        request.setAttribute("userAll",userAll);
        request.getRequestDispatcher("worborrowlist.jsp").forward(request, response);
    }
}
