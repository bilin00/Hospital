<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Return to the Welcome Page</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/login.jsp">Admin Center</a></li>
            </ul>
        </div>
    </div>
</nav>
    <div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <form class="form-signin" action="/AdLogin" name="input" method="post"  method="post">
                <h2 align="center" class="form-signin-heading">Sign in</h2>
                <label for="inputEmail">Username</label>
                <input type="text" id="inputEmail" name="adname" class="form-control" placeholder="Please type in username" required autofocus><br>
                <label for="inputPassword">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Please type in password" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" checked="checked"> Remember your password&nbsp;&nbsp;&nbsp;
                    </label>
                </div>
                
                <input type="submit" class="btn btn-primary" id="btn-login" value="Submit">
                <a href="register.jsp" class="btn btn-default">Register</a>     
            </form>
            <iframe style="display: none;" name="submitFrame" src="about:blank"></iframe>
        </div>
        <div class="col-md-4">
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</body>
</html>