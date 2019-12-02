<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.myh.bean.department"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Information</title>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/CSS/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<link href="${pageContext.request.contextPath}/CSS/myh.css" rel="stylesheet">
<style type="text/css">
td {
	font-size: 12px;
}

h2 {
	margin: 0px
}
</style>

<script>
$(function(){
    $("a").addClass("btn btn-default btn-xs");
     
});
</script>

</head>
<body style="background-color: 	#F0F0F0">
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
           	<a href="main.jsp" class="myh">Return to the homepage</a>
        </div>
        <div class="nav nav-pills" id="nav nav-pills-1">
            <ul class="nav nav-pills navbar-right">
                <li><a href="/admin/exit.jsp">exit</a></li>
            </ul>
        </div>
    </div>
</nav>

<table style="width:800px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
				<h2>Data of the departments</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Department's ID Number"><b>DID</b></td>
			<td title="Department's Name"><b>DNAME</b></td>
			<td title="Department's Telephone Number"><b>DTEL</b></td>
			<td title="Hospital's ID Number"><b>HOSPITAL_HID</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
		</tr>

		<%
			List<department> depts = (List<department>) request.getAttribute("depts");
			if (depts== null || depts.size() < 1) {
				out.print("No data!");
			} 
		%>

    <c:forEach items="${depts}" var="dept" varStatus="st">
        <tr align="center"  bgcolor="#FFF8DC">
            <td>${dept.getDid()}</td>
            <td>${dept.getDname()}</td>
            <td>${dept.getDtel()}</td>
            <td>${dept.getHospital_hid()}</td>
            <td><a href="edit/dept_edit.jsp?did=${dept.getDid()}&dname=${dept.getDname()}&dtel=${dept.getDtel()}&hid=${dept.getHospital_hid()}&start=${start}&sql_option=${sql_option}&val=${val}">edit</a></td>
            <td><a href="DeptDelete?id=${dept.getDid()}&start=${start}&sql_option=${sql_option}&val=${val}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form class="form-signin" action="/DeptAdd?main=yes&sql_option=${sql_option}" onsubmit="check(this)" name="input" method="post">
<table style="width:800px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
<h2>
<input type="submit" value="Add a set of data" class="btn btn-info"><br>
</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Department's ID Number"><b>DID</b></td>
			<td title="Department's Name"><b>DNAME</b></td>
			<td title="Department's Telephone Number"><b>DTEL</b></td>
			<td title="Hospital's ID Number"><b>HOSPITAL_HID</b></td>
		</tr>

<tr align="center">
                				<td><input type="text" id="did" name="did" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="2"  placeholder="Please type in did" required autofocus></td>
                				<td><input type="text" id="dname" name="dname" class="form-control" placeholder="Please type in dname" required></td>
                				<td><input type="text" id="dtel" name="dtel" class="form-control" placeholder="Please type in dtel" required autofocus></td>
                				<td><input type="text" id="hospital_hid" name="hid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="3" placeholder="Please type in hospital_hid" required></td>
</tr>	
</table>
</form>

<table style="width:500px; margin:44px auto" align='center' border='1' cellspacing='0' frame=void rules=none>
<div class="form-group input-group">    
<form class="form-horizontal has-success" action="DeptList" role=form method="post">    

<tr align="center"> 
<td align="center" colspan="2">    
<div class="input-group-btn">
                        <select id="select" name="type" class="form-control" style="width: auto">
                            <option value="did" >did</option>
                            <option value="dname">dname</option>
                            <option value="dtel">dtel</option>
                            <option value="hid">hid</option>
                        </select>
</div>
</td>
<td align="center" colspan="8">
                    <input id="inputSearch" type="text" name="did" class="form-control input-sm" placeholder="Search for ..." required>
</td>
<td align="center" colspan="4">
<span class="input-group-btn">
	<button type="submit" class="btn btn-success">Search by column name</button>
</span> 
</td>
</tr>
</form>
</div>
</table>

<nav>
          <ul class="pager">
            <li><a href="?start=0&sql_option=${sql_option}&val=${val}">first page</a></li>
            <li><a href="?start=${pre}&sql_option=${sql_option}&val=${val}">previous page</a></li>
            <li><a href="?start=${next}&sql_option=${sql_option}&val=${val}">next page</a></li>
            <li><a href="?start=${last}&sql_option=${sql_option}&val=${val}">last page</a></li>
          </ul>           
</nav>

	<h2 align="center">
		<input type="button" value="Return" onclick="history.back()" class="btn btn-default">
	</h2>

<script>
$('#select').on('change',function(){
  $('#inputSearch').attr('name', this.value)
})
</script>

		<script src="js/classie.js"></script>
		<script src="js/sidebarEffects.js"></script>
<script src="js/jquery.min.js"></script>
</body>
</html>