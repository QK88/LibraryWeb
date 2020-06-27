<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-18
  Time: 17:31
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
    <title>管理员操作|图书管理</title>
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
    </style>
</head>
<h1 style="text-align: center">管理员操作</h1>
<body class="body">
<%
    String mess=(String)session.getAttribute("xiaoxi");
    if("".equals(mess)||mess==null){
    }
    else{
%>
<script type="text/javascript">
    alert("<%=mess%>");
</script>
<%session.setAttribute("xiaoxi", "");
}%>
<!--功能一添加新书-->
<div class="topnav">
    <div class="row">
        <a href="worOperate.jsp" target="_self"class="active">查询书籍</a>
        <a href="wornewbook.jsp">添加书籍</a>
        <!--功能三：统计超时名单-->
        <div class="dropdown">
            <span>学生名单</span>
            <ul class="dropdown-content"style="">
                <a href="allrecordList">借阅名单</a>
                <a href="overtimeList">超时名单</a>
                <a href="worstuupdate1.jsp">学生修改</a>
            </ul>
        </div>
        <a href="index.jsp">退出登录</a>
<!--根据出版社，作者，类别，书名检索书，并可以修改-->
</div>
</div>
<div class="leftcolumn">
<div class="container">
    <form action="worSearchlist" >
        <br><label for="publisher">出版社</label><br>
        <input class="searchbox" id="publisher" name="publisher"type="text"><br>
        <br><label for="author">作家</label><br>
        <input class="searchbox" id ="author" name="author"type="text"><br>
        <br><label for="name">书名</label><br>
        <input class="searchbox" id ="name" name="name"type="text"><br>
        <br><label for="type">种类</label><br>
        <select id="type" name="booktype">
            <option value="math">math</option>
            <option value="history">history</option>
            <option value="science">science</option>
            <option value="computer">computer</option>
        </select><input class="button" type="submit"value="检索"><br>
</form>
</div>
</div>
</body>
</html>