package com.util;
//数据库连接工具类
import java.sql.*;
/*
public class connect {

    //mysql驱动包名
    private static  String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static  String URL = "jdbc:mysql://localhost:3306/LIBRARY?characterEncoding=utf8&autoReconnect=true";
    //用户名
    private static String USER = "root";
    //密码
    private static String PASSWORD = "as15290622810";
    private static Connection conn=null;
    /*连接驱动并测试*/
   /* static {

        try {
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (Exception ex) {
            System.out.println(ex.fillInStackTrace());
            throw new RuntimeException("数据库连接失败");
        }
    }
    /*连接数据库*/
  /*  public static Connection getConnection(){
        return conn;
    }
    //关闭数据库
    public static void close(ResultSet rs,PreparedStatement st,Connection con)
    {
        try {
            if (rs != null) {
                rs.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                if(st!=null){
                    st.close(); }
            }catch (SQLException e){
                System.out.println(e.fillInStackTrace());
            }finally {
                if(con!=null){
                    try{
                        con.close();
                    }catch(SQLException e){
                        System.out.println(e.fillInStackTrace());}
                }

            }
        }

    }
    }*/
public class connect {
    //数据库连接地址
    private static  String url = "jdbc:mysql://localhost:3306/LIBRARY?characterEncoding=utf8&autoReconnect=true";
    //用户名
    private static String username = "root";
    //密码
    private static String password = "as15290622810";
    //private static Connection conn=null;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url,username,password);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement stm, Connection conn){
        if(rs!=null)
        {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(stm!=null)
        {
            try {
                stm.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn!=null)
        {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
