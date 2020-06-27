package com.filter;
import javax.servlet.*;
import java.io.IOException;

//类用来解决中文字符集乱码，它需要实现Filter接口，并重写doFilter函数

public class EncodingFilter implements javax.servlet.Filter {
    public EncodingFilter(){
        System.out.println("过滤器构造");
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8"); //将编码改为utf-8
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
