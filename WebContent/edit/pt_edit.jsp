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
           	<a href="main.jsp" class="myh">Return to the homepage</a>&nbsp;&nbsp;
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/exit.jsp">exit</a></li>
            </ul>
        </div>
    </div>
</nav>	
						<header class="codrops-header">
							<h1>Edit the data of patient_treatment<span>Hospital information management system</span></h1>
						</header>
						<div class="main clearfix">
						<form class="form-signin" action="/PtUpdate" onsubmit="check(this)" name="input" method="post">
<input type="hidden" name="start" value=<%=request.getParameter("start") %>>
<input type="hidden" name="sql_option" value=<%=request.getParameter("sql_option") %>>
<input type="hidden" name="val" value=<%=request.getParameter("val") %>>   							
<div id="st-trigger-effects" class="column">
                 				<label for="tdate">TDATE</label>
                				<input type="text" id="tdate" name="tdate" value="<%=request.getParameter("tdate")%>" readonly=readonly class="form-control" autofocus><br>
                 				<label for="tfreq">TFREQ</label>
                				<input type="text" id="tfreq" name="tfreq" value=<%=Integer.parseInt(request.getParameter("tfreq"))%> readonly=readonly class="form-control" ><br>
					<label for="tstatus">TSTATUS</label>
                				<input type="text" id="tstatus" name="tstatus" value="<%=request.getParameter("tstatus")%>" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in tstatus"><br>
                				</div>
							<div class="column">
					<label for="patient_pid">PATIENT_PID</label>
                				<input type="text" id="patient_pid" name="pid" value=<%=Integer.parseInt(request.getParameter("pid"))%> readonly=readonly class="form-control" autofocus><br>
					<label for="treatment_tid">TREATMENT_TID</label>
                				<input type="text" id="treatment_tid" name="tid" value=<%=Integer.parseInt(request.getParameter("tid"))%> readonly=readonly class="form-control" autofocus><br>
                				<label for="physician_phid">PHYSICIAN_PHID</label>
                				<input type="text" id="physician_phid" name="phid" value=<%=Integer.parseInt(request.getParameter("phid"))%> readonly=readonly class="form-control" required>
							</div>
		
<div align=center>					
<input type="submit" class="btn btn-primary" id="btn-login" value="Update">&nbsp;
                				<input type="button" value="Return" onclick="history.back()" class="btn btn-default">
</div>
							</form>
						</div><!-- /main -->
				
		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
    	<script src="js/jquery.min.js"></script>
</body>
</html>