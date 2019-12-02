<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.myh.bean.hospital"%>
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
				<h2>Data of the hospitals</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Hospital's ID Number"><b>HID</b></td>
			<td title="Hospital's Name"><b>HNAME</b></td>
			<td title="Hospital's address"><b>HST_ADDRESS</b></td>
			<td title="City where the hospital is located"><b>HST_CITY</b></td>
			<td title="State where the hospital is located"><b>HSTATE</b></td>
			<td title="Hospital zip code"><b>HZIP</b></td>
			<td><b>Edit</b></td>
			<td><b>Delete</b></td>
</tr>

		<%
			List<hospital> hoss = (List<hospital>) request.getAttribute("hoss");
			if (hoss== null || hoss.size() < 1) {
				out.print("No data!");
			} 
		%>

    <c:forEach items="${hoss}" var="hos" varStatus="st">
        <tr align="center"  bgcolor="#FFF8DC">
            <td>${hos.getHid()}</td>
            <td>${hos.getHname()}</td>
            <td>${hos.getHst_address()}</td>
            <td>${hos.getHcity()}</td>
            <td>${hos.getHstate()}</td>
            <td>${hos.getHzip()}</td>
            <td><a href="edit/hos_edit.jsp?hid=${hos.getHid()}&hname=${hos.getHname()}&hst=${hos.getHst_address()}&hcity=${hos.getHcity()}&hstate=${hos.getHstate()}&hzip=${hos.getHzip()}&start=${start}&sql_option=${sql_option}&val=${val}">edit</a></td>
            <td><a href="HosDelete?id=${hos.getHid()}&start=${start}&sql_option=${sql_option}&val=${val}">delete</a></td>
        </tr>
    </c:forEach>
</table>

<form class="form-signin" action="/HosAdd?main=yes&sql_option=${sql_option}" onsubmit="check(this)" name="input" method="post">
<table style="width:800px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align='center' border='1' cellspacing='0'>

		<tr bgcolor="#EECBAD">
			<td align="center" colspan="9">
<h2>
<input type="submit" value="Add a set of data" class="btn btn-info"><br>
</h2>
			</td>
		</tr>

<tr align="center">
			<td title="Hospital's ID Number"><b>HID</b></td>
			<td title="Hospital's Name"><b>HNAME</b></td>
			<td title="Hospital's address"><b>HST_ADDRESS</b></td>
			<td title="City where the hospital is located"><b>HST_CITY</b></td>
			<td title="State where the hospital is located"><b>HSTATE</b></td>
			<td title="Hospital zip code"><b>HZIP</b></td>
		</tr>

<tr align="center">
                				<td><input type="text" id="hid" name="hid" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="3" placeholder="Please type in hid" required autofocus></td>
                				<td><input type="text" id="hname" name="hname" class="form-control" placeholder="Please type in hname" required></td>
                				<td><input type="text" id="hst_address" name="hst" class="form-control" placeholder="Please type in hst_address" required></td>
                				<td><input type="text" id="hst_city" name="hcity" class="form-control" placeholder="Please type in hst_city" required autofocus></td>
                				<td><input type="text" id="hstate" name="hstate" class="form-control" placeholder="Please type in hstate" required autofocus></td>
                				<td><input type="text" id="hzip" name="hzip" class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="5" placeholder="Please type in hzip" required></td>
</tr>	
</table>
</form>

<table style="width:500px; margin:44px auto" align='center' border='1' cellspacing='0' frame=void rules=none>
<div class="form-group input-group">    
<form class="form-horizontal has-success" action="HosList" role=form method="post">    

<tr align="center"> 
<td align="center" colspan="2">    
<div class="input-group-btn">
                        <select id="select" name="type" class="form-control" style="width: auto">
                            <option value="hid" >hid</option>
                            <option value="hname">hname</option>
                            <option value="hst_address">hst_address</option>
                            <option value="hcity">hst_city</option>
                            <option value="hstate">hstate</option>
                            <option value="hzip">hzip</option>
                        </select>
</div>
</td>
<td align="center" colspan="8">
                    <input id="inputSearch" type="text" name="hid" class="form-control input-sm" placeholder="Search for ..." required>
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