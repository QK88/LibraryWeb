package com.servlet.student;

import com.dao.stuOperater;
import com.entity.student;
import com.entity.stuview;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "stuList",urlPatterns = "/stuList")

public class stuList extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String stuid = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {

            if("stuid".equals(cookie.getName())) {
                stuid=cookie.getValue();
            }
        }//cookie 获取用户信息
        stuOperater ud = new stuOperater();
        List<stuview> userAll = ud.getstu(stuid);//获取所有该用户已借书目的值，传给model
        request.setAttribute("stuAll", userAll);
        request.getRequestDispatcher("stuback.jsp").forward(request, response);
    }


}
