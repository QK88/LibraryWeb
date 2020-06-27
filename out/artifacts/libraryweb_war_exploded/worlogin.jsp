<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-15
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-03-31
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <title>管理员登录|图书管理</title>
    <style type="text/css">
        .header {
            padding: 20px;
            text-align: center;
        //background: white;
        }

        .header h1 {
            font-size: 30px;
        }

        /* 导航条 */
        .topnav {
            overflow: visible;
            background-color: #333;
        }

        /* 导航条链接 */
        .topnav a,span {
            float: left;
            display: block;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }
        /* 链接颜色修改 */
        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        /* 创建两列 */
        /* Left column */
        .leftcolumn {
            float: left;
            width: 75%;
        }
        .dropdown {
            position: relative;
            display: inline-block;
        }
        .dropdown-content {
            color: #f1f1f1;
            display: none;
            position: absolute;
            background: none;
            min-width: 120px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            padding: 34px 12px;
        }
        .dropdown:hover .dropdown-content {
            display: block;
        }
        /* 右侧栏 */
        .rightcolumn{
            float: right;
            width: 40%;
            background-color: #f1f1f1;
            padding-left: 20px;
        }

        /* 图像部分 */
        .fakeimg {
            background-color: #aaa;
            width: 100%;
            padding: 20px;
        }

        /* 文章卡片效果 */
        .card {
            background-color: white;
            padding: 20px;
            margin-top: 20px;
        }

        .container {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }

        .col-25 {
            float: left;
            width: 25%;
            margin-top: 6px;
        }

        .col-75 {
            float: left;
            width: 75%;
            margin-top: 6px;
        }

        /* 清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
        /* 列后面清除浮动 */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }

        /* 底部 */
        .footer {
            padding: 20px;
            text-align: center;
            background: #ddd;
            margin-top: 20px;
        }

        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            padding: 10px;
            background-image:url(./static/img/Library.png);
        }

        /* 头部标题 */

        input[type=password],input[type=text], select, textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 4px;
            resize: vertical;
        }

        label {
            padding: 12px 12px 12px 0;
            display: inline-block;
        }

        input[type=submit] {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: 2px;
            border-radius:4px;
            cursor: pointer;
            float: left;
        }

        input[type=submit]:hover {
            background-color: rgba(23, 23, 22, 0.62);
        }
        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
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
<body>
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
<div class="header">
    <h1>LIBRARY</h1>
</div>
<div class="topnav">
    <a href="index.jsp">学生登录</a>
    <a class="active" href=""target="_self">教师登录</a>
    <a href="#about">关于</a>
    <div class="dropdown"style="">
        <span>注册</span>
        <ul class="dropdown-content">
            <a href="worRegister.jsp">管理者注册</a>
            <a href="sturegister.jsp">学生注册</a>
        </ul>
    </div>
</div>

<div class="rightcolumn">
    <div class="container">
            <form action="worlogin" method="post">
            <label for="worid">Master ID</label>
            <input type="text" id="worid" name="worid" placeholder="Your id..">

            <label for="worpwd">Password</label>
            <input type="password" id="worpwd" name="worpwd" placeholder="Your password..">
            <div class="row">
                <div class="col-25">
                    <input type="submit" value="Submit">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>