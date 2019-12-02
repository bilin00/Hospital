<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.myh.bean.patient"%>
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

<table style="width:1000px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
				<h2>Data of the patients</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Patient's ID Number"><b>PID</b></td>
			<td title="Patient's First Name"><b>PFNAME</b></td>
			<td title="Patient's Last Name"><b>PLNAME</b></td>
			<td title="Patient's Gender"><b>PGENDER</b></td>
			<td title="Patient's Birthday"><b>PBD</b></td>
			<td title="Patient's Race"><b>PRACE</b></td>
			<td title="Patient's Status"><b>PSTATUS</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
		</tr>

		<%
			List<patient> pas = (List<patient>) request.getAttribute("pas");
			if (pas== null || pas.size() < 1) {
				out.print("No data!");
			} 
		%>

    <c:forEach items="${pas}" var="pa" varStatus="st">
        <tr align="center"  bgcolor="#FFF8DC">
            <td>${pa.getPid()}</td>
            <td>${pa.getPfname()}</td>
            <td>${pa.getPlname()}</td>
            <td>${pa.getPgender()}</td>
            <td>${pa.getPbd()}</td>
            <td>${pa.getPrace()}</td>
            <td>${pa.getPstatus()}</td>
            <td><a href="edit/pa_edit.jsp?pid=${pa.getPid()}&pfname=${pa.getPfname()}&plname=${pa.getPlname()}&pgender=${pa.getPgender()}&pbd=${pa.getPbd()}&prace=${pa.getPrace()}&pstatus=${pa.getPstatus()}&start=${start}&sql_option=${sql_option}&val=${val}">edit</a></td>
            <td><a href="PaDelete?id=${pa.getPid()}&start=${start}&sql_option=${sql_option}&val=${val}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form class="form-signin" action="/PaAdd?main=yes&sql_option=${sql_option}" onsubmit="check(this)" name="input" method="post">
<table style="width:1000px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
<h2>
<input type="submit" value="Add a set of data" class="btn btn-info"><br>
</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Patient's ID Number"><b>PID</b></td>
			<td title="Patient's First Name"><b>PFNAME</b></td>
			<td title="Patient's Last Name"><b>PLNAME</b></td>
			<td title="Patient's Gender"><b>PGENDER</b></td>
			<td title="Patient's Birthday"><b>PBD</b></td>
			<td title="Patient's Race"><b>PRACE</b></td>
			<td title="Patient's Status"><b>PSTATUS</b></td>
		</tr>

<tr align="center">
                				<td><input type="text" id="pid" name="pid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="9" placeholder="Please type in pid" required autofocus></td>
                				<td><input type="text" id="pfname" name="pfname" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in pfname" required></td>
                				<td><input type="text" id="plname" name="plname" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in plname" required></td>
                				<td><input type="text" id="pgender" name="pgender" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in pgender" required></td>
                				<td><input type="text" id="pbd" name="pbd" class="form-control" placeholder="Please type in pbd" required autofocus></td>
                				<td><input type="text" id="prace" name="prace" class="form-control" onkeyup=onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in prace"></td>
                				<td><input type="text" id="pstatus" name="pstatus" class="form-control" onkeyup=onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in pstatus" required></td>
</tr>	
</table>
</form>

<table style="width:500px; margin:44px auto" align='center' border='1' cellspacing='0' frame=void rules=none>
<div class="form-group input-group">    
<form class="form-horizontal has-success" action="PaList" role=form method="post">    

<tr align="center"> 
<td align="center" colspan="2">    
<div class="input-group-btn">
                        <select id="select" name="type" class="form-control" style="width: auto">
                            <option value="did" >pid</option>
                            <option value="pfname">pfname</option>
                            <option value="plname">plname</option>
                            <option value="pgender">pgender</option>
                            <option value="pbd">pbd</option>
                            <option value="prace">prace</option>
                            <option value="pstatus">pstatus</option>
                        </select>
</div>
</td>
<td align="center" colspan="8">
                    <input id="inputSearch" type="text" name="pid" class="form-control input-sm" placeholder="Search for ..." required>
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

<script src="js/jquery.min.js"></script>
</body>
</html>