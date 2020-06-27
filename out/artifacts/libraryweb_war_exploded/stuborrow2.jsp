<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-22
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <link href="static/css/base.css" type="text/css" rel="stylesheet">
    <title>学生操作|图书管理</title>
    <style type="text/css">
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }

        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: 2px;
            border-radius:4px;
            cursor: pointer;
            float: right;
        }

    </style>
</head>
<body class="body">
<h1 class="header">学生操作</h1>
<div class="topnav">
    <div class="row">
        <div class="col-25" STYLE="text-align: center">
            <a href=""target="_self">借书</a>
            <a href="stuList">还书</a>
            <a href="stuList">退出登录</a>
        </div>
    </div>
</div>
<div class="container"style="background:#f2f2f2 ">
    <form action="stuSearchlist">
        <label for="publisher">出版社</label>
        <input id="publisher" name="publisher"type="text">
        <label for="author">作家</label>
        <input id ="author" name="author"type="text">
        <label for="name">书名</label>
        <input id ="name" name="name"type="text">
        <label for="type">种类</label>
        <select id="type" name="booktype">
            <option value="math">math</option>
            <option value="history">history</option>
            <option value="science">science</option>
            <option value="computer">computer</option>
        </select><input type="submit"value="检索"><br><br>
    </form>
</div>
<div class="container">
    <table  class="table" width="600" border="1" cellpadding="0" >
        <tr>
            <th>编号</th>
            <th>书名</th>
            <th>作者</th>
            <th>出版社</th>
            <th>类型</th>
            <th>位置</th>
            <th>操作</th>
        </tr>
        <c:forEach var="U" items="${bookAll}"  >
            <form action="stuBorrow" method="post">
                <tr>
                    <td><input type="hidden" value="${U.bid}" name="bookid" ></td>
                    <td><input type="text" value="${U.bname}" name="bookname"></td>
                    <td><input type="text" value="${U.author}" name="author"></td>
                    <td><input type="text" value="${U.publisher}" name="publisher"></td>
                    <td><input type="text" value="${U.type}" name="type"></td>
                    <td><input type="text" value="${U.bposition}"name="position"></td>
                    <td><input type="submit" value="借阅"/></td>
                </tr>
            </form>
        </c:forEach><br>
    </table>
</div>
</body>
</html>
