<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2019-04-15
  Time: 20:20
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
<h1 class="header">学生操作</h1>
<div class="topnav">
    <div class="row">
            <a class="active" href="index.jsp">学生登录</a>
            <a href="worlogin.jsp">教师登录</a>
            <a href="#about">关于</a>
            <div class="dropdown">
                <span>注册</span>
                <ul class="dropdown-content"style="">
                    <a href="worRegister.jsp">管理者注册</a>
                    <a href="sturegister.jsp">学生注册</a>
                </ul>
    </div>
</div>
</div>
<div class="rightcolumn">
    <div class="container">
<form action="stuRegister"method="post">
    <input name="stuname" type="text"value="" placeholder="name"><br><br>
    <input name="stuid" type="text"value="" placeholder="ID"><br><br>
    <input name="stupwd" type="password" placeholder="password"><br><br>
    <input type="radio"name="sex"value="男"checked>男
    <input type="radio"name="sex"value="女">女
    <input class="button" type="submit"value="注册">
</form>
</div>
</div>
</body>
</html>
