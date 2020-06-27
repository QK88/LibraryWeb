package com.servlet.worker;

import com.dao.worOperater;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "bookLose",urlPatterns = "/bookLose")
public class bookLose extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String bid = request.getParameter("bid");
        String sid=request.getParameter("sid");
        worOperater ud = new worOperater();
        if(ud.delete_book(bid)&&ud.credit(sid,-4)){
            request.getSession().setAttribute("xiaoxi", "删除成功");
            request.getRequestDispatcher("worborrowlist.jsp").forward(request, response);
        }else{
            request.getSession().setAttribute("xiaoxi","删除失败");
            response.sendRedirect("worborrowlist.jsp");
        }
    }
}
