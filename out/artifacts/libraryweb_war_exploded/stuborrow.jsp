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
<h1 class="header">学生操作</h1>
<div class="topnav">
    <div class="row">
        <div class="col-25" STYLE="text-align: center">
            <a href="stuborrow.jsp"target="_self">借书</a>
            <a href="stuList">还书</a>
            <a href="index.jsp">退出登录</a>
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
</body>
</html>
