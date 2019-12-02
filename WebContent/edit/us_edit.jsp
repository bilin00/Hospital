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
<title>Add the data of users</title>
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
							<h1>Edit the data of users<span>Hospital information management system</span></h1>
						</header>
						<div class="main clearfix">
						<form class="form-signin" action="/UsUpdate" onsubmit="check(this)" name="input" method="post">
<input type="hidden" name="start" value=<%=request.getParameter("start") %>>
<input type="hidden" name="sql_option" value=<%=request.getParameter("sql_option") %>>
<input type="hidden" name="val" value=<%=request.getParameter("val") %>>   							
<div id="st-trigger-effects" class="column">
                 				<label for="uid">UID</label>
                				<input type="text" id="uid" name="uid" value=<%=Integer.parseInt(request.getParameter("uid"))%> readonly=readonly class="form-control" placeholder="Please type in uid" required autofocus><br>
                 				<label for="ufname">UFNAME</label>
                				<input type="text" id="ufname" name="ufname" value=<%=request.getParameter("ufname")%> class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in ufname" required><br>
					<label for="ulname">ULNAME</label>
                				<input type="text" id="ulname" name="ulname" value=<%=request.getParameter("ulname")%> class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in ulname" required><br>
                				</div>
							<div class="column">
					<label for="urole">UROLE</label>
                				<input type="text" id="urole" name="urole" value=<%=request.getParameter("urole")%> class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in urole" required autofocus><br>
                				<label for="department_did">DEPARTMENT_DID</label>
                				<input type="text" id="department_did" name="did" value=<%=Integer.parseInt(request.getParameter("did"))%> class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="2" placeholder="Please type in department_did" required>
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