package com.servlet.worker;

import com.dao.worOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookDelete",urlPatterns = "/bookDelete")
public class bookDelete extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("bid");
         worOperater ud = new worOperater();
        if(ud.delete_book(id)){
            request.getSession().setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("worbooklist.jsp").forward(request, response);
        }else{
            request.getSession().setAttribute("xiaoxi","删除失败");
            response.sendRedirect("worbooklist.jsp");
        }
    }
}
