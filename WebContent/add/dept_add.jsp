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
<title>Add the data of department</title>
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
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/CSS/myh.css" rel="stylesheet">
</head>

<script type="text/javascript">

$("#id").keyup(function(){
    	
	var c=$(this);
    	
	if(/[^\d]/.test(c.val())){
    		
		var temp=c.val().replace(/[^\d]/g,'');
    		
		$(this).val(temp);
    		
		$("#t1").css({'display':'block'});
    	
	}else{
    		
		$("#t1").css({'display':'none'});
    	
	}



$("#did").blur(function(){
    	
    		
	var d1=$(this);
    		
	if(d1.val().length!=2){
    			
    		 
	$(this).val('');
    		
    		 
	$("#did1").css({'display':'block'});
        	
	}else{
        		
		$("#did1").css({'display':'none'});
    		
	}
    	
	})
</script>

<body style="background-color: 	#F0F0F0">
	<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
           	<a href="main.jsp" class="myh">Return to the homepage</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/admin/exit.jsp">exit</a></li>
            </ul>
        </div>
    </div>
</nav>	
						<header class="codrops-header">
							<h1>Add the data of department<span>Hospital information management system</span></h1>
						</header>
<div class="main clearfix">
						<form class="form-signin" action="${pageContext.request.contextPath}/DeptAdd" onsubmit="check(this)" name="input" method="post">
							<div id="st-trigger-effects" class="column">
                 				<label for="did">DID</label>
                				<input type="text" id="did" name="did" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="2"  placeholder="Please type in did" required autofocus><br>
					<span style="display:none;border:0;float:right;margin-right:50px" id="did1" >The length of DID must be 2!</span>

                 				<label for="dname">DNAME</label>
                				<input type="text" id="dname" name="dname" class="form-control" placeholder="Please type in dname" required><br>
                				</div>
							<div class="column">
					<label for="dtel">DTEL</label>
                				<input type="text" id="dtel" name="dtel" class="form-control" placeholder="Please type in dtel" required autofocus><br>
                				<label for="hospital_hid">Hospital_hid</label>
                				<input type="text" id="hospital_hid" name="hid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="3" placeholder="Please type in hospital_hid" required>
					<span style="display:none;border:0;float:right;margin-right:50px" id="hid1" >The length of HID must be 3!</span>				
</div>
		
					<div align=center>					
					<input type="submit" class="btn btn-primary" id="btn-login" value="Add">&nbsp;
                				&nbsp;<input type="button" value="Return" onclick="history.back()" class="btn btn-default">
					</div>
							</form>
						</div><!-- /main -->
				
		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
    	<script src="js/jquery.min.js"></script>
</body>
</html>