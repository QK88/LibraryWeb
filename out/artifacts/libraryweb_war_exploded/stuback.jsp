<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-19
  Time: 15:20
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
            <a href="stuborrow.jsp">借书</a>
            <a href="stuback.jsp"target="_self">还书</a>
            <a href="index.jsp">退出登录</a>
        </div>
    </div>
</div>
<div class="container">
<table  class="table">
    <tr>
        <th>ID</th>
        <th>学号</th>
        <th>书名</th>
        <th>借书日期</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${stuAll}"  >
        <form action="stuBack">
            <tr>
                <td><input type="text" value="${U.sid}" name="sid" ></td>
                <td><input type="text" value="${U.bid}" name="bid"></td>
                <td><input type="text" value="${U.bname}" name="bname"></td>
                <td><input type="date" value="${U.rdate}" name="overdate"></td>
                <td><a class="button" href="stuBack?bid=${U.bid}">还书</a>
            </tr>
        </form>
    </c:forEach>
</table>
</div>
</body>
</html>
