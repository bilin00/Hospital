<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add the data of disease</title>
<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<meta name="description" content="Sidebar Transitions: Transition effects for off-canvas views" />
		<meta name="keywords" content="transition, off-canvas, navigation, effect, 3d, css3, smooth" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/normalize.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/demo.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/icons.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/component.css" />
		<script src="js/modernizr.custom.js"></script>
    <link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/CSS/myh.css" rel="stylesheet">
</head>

<body style="background-color: 	#F0F0F0">
	<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
           	<a href="http://35.243.252.141/main.jsp" class="myh">Return to the homepage</a>&nbsp;&nbsp;
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/exit.jsp">exit</a></li>
            </ul>
        </div>
    </div>
</nav>	
						<header class="codrops-header">
							<h1>Add the data of disease<span>Hospital information management system</span></h1>
						</header>
						<div class="main clearfix">
						<form class="form-signin" action="/DiAdd" onsubmit="check(this)" name="input" method="post">
							<div id="st-trigger-effects" class="column">
                 				<label for="deid">DEID</label>
                				<input type="text" id="deid" name="deid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6" placeholder="Please type in deid" required autofocus><br>
</div>
<div class="column">
                 				<label for="dename">DENAME</label>
                				<input type="text" id="dename" name="dename" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in dename" required><br>
							
							</div>
		
<div align=center>					
<input type="submit" class="btn btn-primary" id="btn-login" value="Add">&nbsp;&nbsp;&nbsp;
                				<input type="button" value="Return" onclick="history.back()" class="btn btn-default">
</div>
							</form>
						</div><!-- /main -->
				
		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
    	<script src="js/jquery.min.js"></script>
</body>
</html>