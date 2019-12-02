<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.myh.bean.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>信息修改</title>
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
<script type="text/javascript">
	function onclick(){
		window.location=encodeURI("xiugai.jsp");
	}

</script>
<body>
<%User user=new User(); %>
<%request.setCharacterEncoding("utf-8"); %>
<%String id = request.getParameter("id");%>
<div id="st-container" class="st-container">
			
		<nav class="st-menu st-effect-11" id="menu-11">
				<h2 class="icon icon-lab">医院管理</h2>
				<ul>
					<li><a class="icon icon-data" href="finddetail.jsp">根据关键信息查询</a></li>
					<li><a class="icon icon-location" href="index.jsp">添加人员信息</a></li>
					<li><a class="icon icon-study" href="update2.jsp">修改人员信息</a></li>
					<li><a class="icon icon-photo" href="FindServlet">查询所有信息</a></li>
					<li><a class="icon icon-wallet" href="muyahai.jsp">MuYaHai</a></li>
				</ul>
			</nav>


			<!-- content push wrapper -->
			<div class="st-pusher">
				<div class="st-content"><!-- this is the wrapper for the content -->
					<div class="st-content-inner"><!-- extra div for emulating position:fixed of the menu -->
						<!-- Top Navigation -->
						<div id="st-trigger-effects" class="codrops-top clearfix">
							<button data-effect="st-effect-11">菜单栏</button>
							<a class="codrops-icon codrops-icon-prev" href="login.jsp"><span>登录/注册</span></a>
							<span class="right"><a class="codrops-icon codrops-icon-drop" href=""><span>Made by MuYaHai</span></a></span>
						</div>
						<header class="codrops-header">
							<h1>修改人员信息 <span>Hospital information management system</span></h1>
						</header>
						<div class="main clearfix">
						<form class="form-signin" action="UpdateServlet" method="post">
							<div id="st-trigger-effects" class="column">
                 				<label for="inputID">用户ID</label>
                				<input type="text" id="inputID" name="id" class="form-control" placeholder="请输入id" required autofocus value="<%=id %>" readonly="readonly"><br>
                 				<label for="inputDoctorName">医生姓名</label>
                				<input type="text" id="inputDoctorName" name="doctorname" class="form-control" placeholder="请输入医生姓名" required><br>
                				<label for="inputHospital">医院名称</label>
                				<input type="text" id="inputHospital" name="hospitalname" class="form-control" placeholder="请输入医院名称" required autofocus><br>
                				<label for="inputMold">用户类型</label>
                				<input type="text" id="inputMold" name="mold" class="form-control" placeholder="请输入用户类型" required>
							</div>
							<div class="column">
								<label for="inputSection">科室</label>
                				<input type="text" id="inputSection" name="section" class="form-control" placeholder="请输入科室" required autofocus><br>
                				<label for="inputAddress">地址</label>
                				<input type="text" id="inputAddress" name="address" class="form-control" placeholder="请输入地址" required><br>
                				<label for="inputPhone">电话</label>
                				<input type="text" id="inputPhone" name="phone" class="form-control" placeholder="请输入电话号码" required><br><br>
                				<input type="submit" class="btn btn-primary" id="btn-login" value="修改" onclick="return onclick()">
                				
                				<input type="button" value="返回" onclick="history.back()" class="btn btn-default">
							</div>
							</form>
						</div><!-- /main -->
					</div><!-- /st-content-inner -->
				</div><!-- /st-content -->
			</div><!-- /st-pusher -->
		</div><!-- /st-container -->
		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
    	<script src="js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</body>
</html>