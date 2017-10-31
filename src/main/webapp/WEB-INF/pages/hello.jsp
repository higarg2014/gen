<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Hello World!</title>
    <style>
        #header{
            background-color: aqua;
            color: white;
            text-align: center;
        }

        body{
            background-color: #333333;
        }

        #container{
            background-color: white;
            width: 800px;
            margin-left: auto;
            margin-right: auto;

        }

        #contain{
            padding: 10px 10px 10px 10px;
        }

        #nav{
          width: 180px;
            float: left;
        }
        #main{
            width: 600px;
            float: right;
        }

        #footer{
            clear: both;
        }

    </style>
</head>
<body>
<%--<h1>Hello <b><c:out value="${pageContext.request.remoteUser}"/></b> </h1>--%>
<form action="/logout" method="post">
    <input type="submit" value="Sign Out"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<div id="container">
    <div id="header">This is my heading</div>

    <div id="contain">
        <div id="nav">
            <ul>
                <li>home</li>
                <li>about</li>
                <li>contact us</li>
            </ul>

        </div>
        <div id="main">
            <p>main content</p>


        </div>

    </div>

    <div id="footer"> this my footer</div>

</div>
</body>
</html>
