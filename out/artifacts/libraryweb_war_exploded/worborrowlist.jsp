<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-22
  Time: 09:17
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
    <title>添加书籍|图书管理</title>
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
        input[type=password],input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
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
}
%>
<h1 style="text-align: center">管理员操作</h1>
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
<!--超时名单，系统自动直接实现对学生的扣分，如果，在此可以实现图书的丢失或归还，停止扣分
丢失：将此记录转到丢失表
归还：删除记录-->
<div class="container">
    <table class="table">
    <tr>
        <th>学号</th>
        <th>学生</th>
        <th>书的编号</th>
        <th>书名</th>
        <th>借阅日期</th>
        <th>操作</th>
    </tr>
    <c:forEach var="U" items="${userAll}"  >
            <form action="bookLose" method="post">
                <tr>
                <td><input type="text" value="${U.sid}" name="sid" ></td>
                <td><input type="text" value="${U.sname}" name="sname"></td>
                <td><input type="text" value="${U.bid}" name="bid"></td>
                <td><input type="text" value="${U.bname}" name="bname"></td>
                <td><input type="text" value="${U.rdate}" name="rdate"></td>
                <td><input class="button" type="submit" value="丢失"/></td>
                </tr>
            </form>
    </c:forEach>
</table>
</div>
</body>
</html>
