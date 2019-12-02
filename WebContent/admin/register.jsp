<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign up</title>
<link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">WDC Hospital information management system&nbsp;</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/login.jsp">Sign in</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <form class="form-signin" action="http://35.243.252.141/AdAdd" name="input" method="post">
                <h2 class="form-signin-heading">Create account</h2>
                 <label for="inputUserName">Username</label>
                <input type="text" id="inputUserName" name="adname" class="form-control" placeholder="Username" required autofocus>
<span id="checkResult"></span><br>

                <label for="inputPassword">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required autofocus><br>
                <input type="submit" class="btn btn-primary" id="btn-login" value="Submit">
                <a href="login.jsp" class="btn btn-default">Return to the sign-in page</a>
            </form>
            <iframe style="display: none;" name="submitFrame" src="about:blank"></iframe>
        </div>
        <div class="col-md-4">
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</body>
</html>