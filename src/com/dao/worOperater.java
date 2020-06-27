package com.dao;

import com.entity.book;
import com.entity.student;
import com.entity.stuview;
import com.entity.worker;
import com.util.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class worOperater {
    //根据id删除书籍：管理员操作
    public boolean delete_book(String bid) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 0;
        String sql = "delete from Book where B_in=false and B_id ='" + bid + "'";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            flag = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.fillInStackTrace());
            throw new RuntimeException("删除图书失败", e);
        } finally {
            connect.close(rs, pst, con);
        }
        if (flag > 0) return true;
        else return false;
    }

    //根据ID删除学生，还是扣除学生的分数
    public boolean delete_stu(String sid) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 0;

        String sql = "delete from student where S_id =?";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, sid);
            flag = pst.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("删除学生失败", e);
        } finally {
            connect.close(rs, pst, con);

        }
        if (flag > 0) return true;
        else return false;
    }


    public boolean login(String id, String password) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select distinct W_pwd from Worker where W_id=" + id;
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("W_pwd").equals(password)) {
                    flag = true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        } finally {
            connect.close(rs, pst, con);
        }
        return flag;

    }

    public boolean register(worker user) {
        //添加表成员,学生注册，输入学生个人信息
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int i = 0;

        String sql = "insert into Worker(W_id,W_pwd)values(?,?)";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, user.getId());
            pst.setString(2, user.getWpwd());
            i = pst.executeUpdate();

        } catch (SQLDataException e) {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            throw new RuntimeException("注册失败", e);

        } finally {
            connect.close(rs, pst, con);
            if (i > 0) flag = true;
            return flag;
        }
    }

    //添加书
    public boolean newbook(book user) {
        //添加表的完整信息，添加书
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 0;

        String sql = "insert into Book(B_id,B_name,B_position,B_type,B_publisher,B_author)values(?,?,?,?,?,?)";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getBid());
            pst.setString(2, user.getBname());
            pst.setString(3, user.getBposition());
            pst.setString(4, user.getType());
            pst.setString(5, user.getPublisher());
            pst.setString(6, user.getAuthor());
            flag = pst.executeUpdate();
        } catch (SQLException q) {
            System.out.println(q.fillInStackTrace());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        } finally {
            connect.close(rs, pst, con);
        }
        if (flag > 0) return true;
        else return false;

    }

    //更新书的信息
    public boolean update(book user) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int flag = 0;
        String sql = "update book set B_name=?,B_position=?,B_in=?,B_type=?,B_publisher=?,B_author=?where B_id=?";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getBname());
            pst.setString(2, user.getBposition());
            pst.setBoolean(3, user.isIn());
            pst.setString(4, user.getType());
            pst.setString(5, user.getPublisher());
            pst.setString(6, user.getAuthor());
            pst.setString(7, user.getBid());
            flag = pst.executeUpdate();
        } catch (SQLException q) {
            System.out.println(q.fillInStackTrace());
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        } finally {
            connect.close(rs, pst, con);
        }
        if (flag > 0) return true;
        else return false;

    }

    //根据书的种类进行检索，反馈到jsp打印清单
    public List<book> getbookAll(book book) {
        String sql = null;
        if (!book.getBname().equals("")) {
            sql = "select  * from Book where B_name ='" + book.getBname() + "'";
        } else if (!book.getAuthor().equals("")) {
            sql = "select * from Book where B_author='" + book.getAuthor() + "'";
        } else if (!book.getPublisher().equals("")) {
            sql = "select * from Book where B_publisher=" + book.getPublisher() + " and B_type='" + book.getType() + "'";
        } else {
            //sql="select * from Book where B_type ="+book.getType()+"";
            sql = "select * from Book where B_type='" + book.getType() + "'";

        }
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<book> list = new ArrayList<>();
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                book user = new book();
                user.setBid(rs.getString("B_id"));
                user.setBname(rs.getString("B_name"));
                user.setBposition(rs.getString("B_position"));
                user.setAuthor(rs.getString("B_author"));
                user.setType(rs.getString("B_type"));
                user.setPublisher(rs.getString("B_publisher"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        } finally {
            connect.close(rs, pst, con);
        }
        return null;
    }

    //附加功能：实现超时人员列表，管理员扣除分数
    public List<stuview> getstuAll(int i) {
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = null;
        if (i == 0) {
            sql = "select R_S_id,R_B_id,B_name,S_name,R_date from robot,Student,Book where R_S_id=S_id and R_B_id=B_id and R_date<=DATE_SUB(NOW(),INTERVAL 1 minute ) AND R_date < NOW()";
        } else {
            sql = "select R_S_id,R_B_id,B_name,S_name,R_date from robot,Student,Book where R_S_id=S_id and R_B_id=B_id";
        }
        List<stuview> list = new ArrayList<>();
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                stuview user = new stuview();
                user.setSid(rs.getString("R_S_id"));
                user.setBid(rs.getString("R_B_id"));
                user.setBname(rs.getString("B_name"));
                user.setSname(rs.getString("S_name"));
                user.setRdate(rs.getDate("R_date"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        } finally {
            connect.close(rs, pst, con);
        }
        return null;
    }
    //获得单个学生信息
    public List<student> getstu(String sid){
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String sql = "select * from Student where S_id='"+sid+"'";
        List<student> list=new ArrayList<>();
        try{
            student user=new student();
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                user.setSid(rs.getString("S_id"));
                user.setPassword(rs.getString("S_pwd"));
                user.setCredit(rs.getInt("S_credit"));
                user.setSex(rs.getString("S_sex"));
                user.setSname(rs.getString("S_name"));
                list.add(user);
            }return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            connect.close(rs, pst, con);
        }
    return null;

}
    //改变学生信用值
    public boolean credit(String id, int credit) {

        int flag = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "update Student set S_credit=S_credit+" + credit + " where S_id='" + id + "'";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            flag=pst.executeUpdate();
        } catch(SQLException e)
    {System.out.println(e.fillInStackTrace());
    }catch(Exception e)
    {
        System.out.println(e.fillInStackTrace());
    }finally
    {
        connect.close(rs, pst, con);
    }
        if(flag>0)
        return true;
        else return false;
}
    //改变学生信息
    public boolean updatestu(student user) {

        int flag = 0;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "update Student set S_name=?,S_credit=?,S_sex=?,S_pwd=? where S_id='" + user.getSid() + "'";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,user.getSname());
            pst.setInt(2,user.getCredit());
            pst.setString(3,user.getSex());
            pst.setString(4,user.getPassword());
            flag=pst.executeUpdate();
        } catch(SQLException e)
        {System.out.println(e.fillInStackTrace());
        e.getErrorCode();
        }catch(Exception e)
        {
            System.out.println(e.fillInStackTrace());
            e.printStackTrace();
        }finally
        {
            connect.close(rs, pst, con);
        }
        if(flag>0)
            return true;
        else return false;
    }


}
