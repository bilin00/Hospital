<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.myh.bean.treatment"%>
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
				<h2>Data of the treatments</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Treatment's ID Number"><b>TID</b></td>
			<td title="Treatment's Name"><b>TNAME</b></td>
			<td title="Treatment's Type"><b>TTYPE</b></td>
			<td title="Disease's ID Number"><b>DISEASE_DEID</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
		</tr>

		<%
			List<treatment> trs = (List<treatment>) request.getAttribute("trs");
			if (trs== null || trs.size() < 1) {
				out.print("No data!");
			} 
		%>

    <c:forEach items="${trs}" var="tr" varStatus="st">
        <tr align="center"  bgcolor="#FFF8DC">
            <td>${tr.getTid()}</td>
            <td>${tr.getTname()}</td>
            <td>${tr.getTtype()}</td>
            <td>${tr.getDeid()}</td>
            <td><a href="edit/tr_edit.jsp?id=${tr.getTid()}&tname=${tr.getTname()}&ttype=${tr.getTtype()}&deid=${tr.getDeid()}&start=${start}&sql_option=${sql_option}&val=${val}">edit</a></td>
            <td><a href="TrDelete?id=${tr.getTid()}&start=${start}&sql_option=${sql_option}&val=${val}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form class="form-signin" action="/TrAdd?main=yes&sql_option=${sql_option}" onsubmit="check(this)" name="input" method="post">
<table style="width:800px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
<h2>
<input type="submit" value="Add a set of data" class="btn btn-info"><br>
</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Treatment's ID Number"><b>TID</b></td>
			<td title="Treatment's Name"><b>TNAME</b></td>
			<td title="Treatment's Type"><b>TTYPE</b></td>
			<td title="Disease's ID Number"><b>DISEASE_DEID</b></td>
		</tr>

<tr align="center">
                				<td><input type="text" id="tid" name="tid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="10" placeholder="Please type in tid" required autofocus></td>
                				<td><input type="text" id="tname" name="tname" class="form-control" placeholder="Please type in tname" required></td>
                				<td><input type="text" id="ttype" name="ttype" class="form-control" onkeyup="this.value=this.value.toUpperCase()" placeholder="Please type in ttype" required autofocus></td>
                				<td><input type="text" id="disease_deid" name="deid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="6" placeholder="Please type in disease_deid" required></td>
</tr>	
</table>
</form>

<table style="width:500px; margin:44px auto" align='center' border='1' cellspacing='0' frame=void rules=none>
<div class="form-group input-group">    
<form class="form-horizontal has-success" action="TrList" role=form method="post">    

<tr align="center"> 
<td align="center" colspan="2">    
<div class="input-group-btn">
                        <select id="select" name="type" class="form-control" style="width: auto">
                            <option value="tid" >tid</option>
                            <option value="tname">tname</option>
                            <option value="ttype">ttype</option>
                            <option value="deid">disease_deid</option>
                        </select>
</div>
</td>
<td align="center" colspan="8">
                    <input id="inputSearch" type="text" name="tid" class="form-control input-sm" placeholder="Search for ..." required>
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