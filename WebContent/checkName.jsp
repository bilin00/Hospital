<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		try {
			// 加载数据库驱动，注册到驱动管理器
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&useSSL=false";
			// 数据库用户名
			String us = "root";
			// 数据库密码
			String pw = "123456";
			// 创建Connection连接
			Connection conn = DriverManager.getConnection(url, us,
					pw);
			String sql = "select * from tb_mima where username='"+name+"'";
			
			 // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
			// 判断是否更新成功
			if (rs.next()) {
				// 已注册过
				out.print("<font color='red'>The username has been registered!</font>");
				out.print("<script>document.getElementById("btn-login").disabled = true</script>");
			}
			// 关闭PreparedStatement，释放资源
			ps.close();
			// 关闭Connection，释放资源
			conn.close();
		} catch (Exception e) {
			out.print("信息搜寻失败！");
			e.printStackTrace();
		}
	%>
	<br>
</body>
</html>