<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-18
  Time: 17:33
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
    <!--弹框-->
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
            float: right;
        }

    </style>
</head>
<body class="body">
<div class="header">
    <h1>LIBRARY</h1>
</div>
<div class="topnav">
    <a href="index.jsp">学生登录</a>
    <a class="active" href="worlogin.jsp">教师登录</a>
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
<form action="worregister"method="post">
    <input name="worid" type="text"value="" placeholder="id"><br><br>
    <input name="workey" type="password"value="" placeholder="key"><br><br>
    <input type="submit"value="注册">
</form>
</div>
    </div>
</body>
</html>
