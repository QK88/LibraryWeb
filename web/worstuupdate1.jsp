<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
                <a href="worstuupdate1.jsp" target="_self">学生修改</a>
            </ul>
        </div>
        <a href="index.jsp">退出登录</a>
        <!--根据出版社，作者，类别，书名检索书，并可以修改-->
    </div>

</div>
<div class="rightcolumn">
    <div class="container">
        <form action="stuSearch"method="post">
            <input style="width: 80%;height:8%;" name="stuid" type="text"value=""placeholder="ID">
            <input style="margin-bottom: 4px" class="button" type="submit"value="查询">
        </form>
    </div>
</div>
</body>
</html>
