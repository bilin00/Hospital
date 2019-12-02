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
<title>Add the data of hospital</title>
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
							<h1>Edit the data of hospital<span>Hospital information management system</span></h1>
						</header>
						<div class="main clearfix">
						<form class="form-signin" action="/HosUpdate" onsubmit="check(this)" name="input" method="post">
<input type="hidden" name="start" value=<%=request.getParameter("start") %>>
<input type="hidden" name="sql_option" value=<%=request.getParameter("sql_option") %>>
<input type="hidden" name="val" value=<%=request.getParameter("val") %>>   							
<div id="st-trigger-effects" class="column">
                 				<label for="hid">HID</label>
                				<input type="text" id="hid" name="hid" value=<%=Integer.parseInt(request.getParameter("hid"))%> readonly=readonly class="form-control" placeholder="Please type in hid" required autofocus><br>
                 				<label for="hname">HNAME</label>
                				<input type="text" id="hname" name="hname" value=<%=request.getParameter("hname")%> class="form-control" placeholder="Please type in hname" required><br>
					<label for="hst_address">hst_address</label>
                				<input type="text" id="hst_address" name="hst" value=<%=request.getParameter("hst")%> class="form-control" placeholder="Please type in hst_address" required><br>
                				</div>
							<div class="column">
					<label for="hst_city">hst_city</label>
                				<input type="text" id="hst_city" name="hcity" value=<%=request.getParameter("hcity")%> class="form-control" placeholder="Please type in hst_city" required autofocus><br>
					<label for="hstate">hstate</label>
                				<input type="text" id="hstate" name="hstate" value=<%=request.getParameter("hstate")%> class="form-control" placeholder="Please type in hstate" required autofocus><br>
                				<label for="hzip">hzip</label>
                				<input type="text" id="hzip" name="hzip" value=<%=Integer.parseInt(request.getParameter("hzip"))%> class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="5" placeholder="Please type in hzip" required>
							</div>
		
<div align=center>					
<input type="submit" class="btn btn-primary" id="btn-login" value="Update">&nbsp;&nbsp;&nbsp;
                				<input type="button" value="Return" onclick="history.back()" class="btn btn-default">
</div>
							</form>
						</div><!-- /main -->
				
		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
    	<script src="js/jquery.min.js"></script>
</body>
</html>