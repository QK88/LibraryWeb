package com.dao;
import com.entity.book;
import com.entity.student;
import com.entity.stuview;
import com.util.connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class stuOperater  {
    //public boolean stuLogin(String name,String id);//登录

    //public boolean borrow(String bid,String sid,Date time);//学生借阅书籍
   // public boolean back(String sid,String bid);//还书
    //登录
    //登录
    public boolean login(String id, String pwd) {
        boolean flag = false;
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql="select S_pwd from Student where S_id='"+id+"'";
        //String sql_1="insert into Student(S_id,S_name,S_time)values(name,id,now())";
        try {
            con=connect.getConnection();
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery(sql);

            while(rs.next()){
                if (rs.getString("S_pwd").equals(pwd)){
                    flag=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            connect.close(rs,pst,con);
        }

        return flag;

    }

    //查询列表
    //注册
    public boolean register(student user) {
        //添加表成员,学生注册，输入学生个人信息
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int i = 0;

        String sql = "insert into Student(S_id,S_name,S_credit,S_sex,S_pwd)values(?,?,?,?,?)";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);

            pst.setString(1, user.getSid());
            pst.setString(2, user.getSname());
            pst.setInt(3, user.getCredit());
            pst.setString(4, user.getSex());
            pst.setString(5,user.getPassword());

            i=pst.executeUpdate();

        } catch (SQLDataException e){
            System.out.println(e.fillInStackTrace());
        }
        catch (Exception e) {
            System.out.println(e.fillInStackTrace());
            throw new RuntimeException("注册失败", e);

        } finally {
            connect.close(rs, pst, con);
            if(i>0)flag=true;
            return flag;
        }
    }

    //借书,先判断书是否存在，是否可借，信用
    public boolean borrow(String bid,String bname,String sid) {
        //添加借书时学生操作，输入学号，与书编号
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        boolean bin=false;
        int flag=0;//修改的行数
        int flag_2=0;
        int credit=100;//查询姓名与信用
        if(bid!=null){
            String sql_2="select B_in from Book where B_id=?";
            String sql_1="select distinct S_credit from Student where S_id =?";
            try {
                con = connect.getConnection();
                pst=con.prepareStatement(sql_2);
                pst.setString(1, bid);
                rs = pst.executeQuery();
                while(rs.next()){
                    bin=rs.getBoolean("B_in");
                }
                rs.close();
                pst.close();
                pst = con.prepareStatement(sql_1);
                pst.setString(1, sid);
                rs = pst.executeQuery();
                while (rs.next()) {
                    credit = rs.getInt("S_credit");
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            catch(Exception e){
                System.out.println(e.fillInStackTrace());
            }
        }
        else if(bname!=null){

            String sql_4="select B_id ,B_in from Book where B_name=?"+bname;

            String sql_3="select S_credit from Student where S_id =?"+sid;
            try {
                if(con!=null)con.close();
                con = connect.getConnection();
                pst = con.prepareStatement(sql_3);
                rs = pst.executeQuery();
                while (rs.next()) {
                    credit = rs.getInt("S_credit");
                }
                rs.close();
                pst.close();
                pst = con.prepareStatement(sql_4);
                rs = pst.executeQuery();
                while(rs.next()){
                    bin=rs.getBoolean("B_in");
                    bid=rs.getString("B_id");
                }
                rs.close();
                pst.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException("查无此人", e);
            }

        }

        if(bin&&credit>60){
        String sql = "insert into Robot(R_S_id,R_B_id,R_date)values(?,?,now())";
        String sql1="update Book set B_in=false where B_id='"+bid+"'";
        try {
                pst = con.prepareStatement(sql);
                pst.setString(1, sid);
                pst.setString(2, bid);
                flag=pst.executeUpdate();
                pst.close();
                pst = con.prepareStatement(sql1);
                flag_2=pst.executeUpdate();
            } catch(SQLException e){
            e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e.fillInStackTrace());
                e.printStackTrace();
            }finally {
            connect.close(rs,pst,con);
        }
            if(flag>0&&flag_2>0)return true;
                else return false;
        }
        else{
            return false;
        }
    }

    //输入学号查询书单,没有缓存的功能较为快捷
    /*public void search(student user){

        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        String sql_1="select distinct B_id from Student where S_B_id =?";
        try{
            con=connect.getConnection();
            pst=con.prepareStatement(sql_1);
            pst.setString(1,user.getSid());
            rs=pst.executeQuery();
            while(rs.next()){
                String bid=rs.getString("B_id");
                System.out.println("已借："+bid+"\n");
            }
        }catch(Exception e){
            throw new RuntimeException("查无此人",e);
        }finally {
            connect.close(rs,pst,con);
        }
    }
*/
    public List<book> getbookAll(book book) {
        String sql=null;
        if(!book.getBname().equals("")){
            sql="select  * from Book where B_in=true and B_name ='"+book.getBname()+"'";
        }else if(!book.getAuthor().equals("")){
            sql="select * from Book where B_in=true and B_author='"+book.getAuthor()+"'";
        }else if(!book.getPublisher().equals("")){
            sql="select * from Book where B_in=true and B_publisher="+book.getPublisher()+" and B_type='"+book.getType()+"'";
        }else {
            //sql="select * from Book where B_type ="+book.getType()+"";
            sql="select * from Book where B_in=true and B_type='"+book.getType()+"'";

        }
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        List<book> list = new ArrayList<>();
        try {
            con= connect.getConnection();
            pst=con.prepareStatement(sql);
            rs =pst.executeQuery();
            while(rs.next()){
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
        }finally {
            connect.close(rs, pst, con);
        }
        return null;
    }
    public List<stuview> getstu(String sid) {
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;

        String sql="select R_S_id,R_B_id,B_name,S_name,R_date from robot,Student,Book where R_S_id=S_id and R_B_id=B_id and S_id="+sid;
        List<stuview> list = new ArrayList<>();
        try {
            //if(con!=null)con.close();
            con= connect.getConnection();
            pst=con.prepareStatement(sql);
            rs =pst.executeQuery();
            while(rs.next()) {
                stuview user = new stuview();
                user.setSid(rs.getString("R_S_id"));
                user.setSname(rs.getString("S_name"));
                user.setRdate(rs.getDate("R_date"));
                user.setBid(rs.getString("R_B_id"));
                user.setBname(rs.getString("B_name"));
                list.add(user);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.fillInStackTrace());
        }
        finally {
            connect.close(rs, pst, con);
        }
        return null;
    }
    //根据学号，书编号还书
    public boolean back(String sid,String bid){
        //输入要还的学号，和要还的书号
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
        int i=0,j=0;

        String sql="delete from robot where R_S_id = ? and R_B_id= ?";
        String sql1="update book set B_in = true where B_id ='"+bid+"'";
        try {
            con = connect.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, sid);
            pst.setString(2, bid);
            i = pst.executeUpdate();
            pst.close();
            pst = con.prepareStatement(sql1);
            j = pst.executeUpdate();

        }catch (SQLDataException e){
            System.out.println(e.fillInStackTrace());

        }catch (Exception e)
        {
        System.out.println(e.fillInStackTrace());
        }finally {
            connect.close(rs,pst,con);}
            if(i>0&&j>0)
                return true;
            else {
                return false;
        }
    }


}
