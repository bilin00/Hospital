<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加信息</title>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
	%>
	<jsp:useBean id="user" class="com.myh.bean.User"></jsp:useBean>
	<jsp:setProperty property="*" name="user" />
	<%
		try {
			// 加载数据库驱动，注册到驱动管理器
			Class.forName("com.mysql.jdbc.Driver");
			// 数据库连接字符串
			String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			// 数据库用户名
			String username = "root";
			// 数据库密码
			String password = "123456";
			// 创建Connection连接
			Connection conn = DriverManager.getConnection(url, username,
					password);
			String sql = "insert into tb_inf(id,doctorname,hospitalname,section,mold,address,phone) values(?,?,?,?,?,?,?)";
			// 获取PreparedStatement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getId());
			// 对SQL语句中的第1个参数赋值
			ps.setString(2, user.getDoctorname());
			// 对SQL语句中的第2个参数赋值
			ps.setString(3, user.getHospitalname());
			// 对SQL语句中的第3个参数赋值
			ps.setString(4,user.getSection());
			// 对SQL语句中的第4个参数赋值
			ps.setString(5, user.getMold());
			// 对SQL语句中的第5个参数赋值
			ps.setString(6, user.getAddress());
			// 对SQL语句中的第6个参数赋值
			ps.setString(7, user.getPhone());
			// 对SQL语句中的第7个参数赋值
			// 执行更新操作，返回所影响的行数
			int row = ps.executeUpdate();
			// 判断是否更新成功
			if (row > 0) {
				// 更新成输出信息
				response.sendRedirect("success.jsp");
			}
			// 关闭PreparedStatement，释放资源
			ps.close();
			// 关闭Connection，释放资源
			conn.close();
		} catch (Exception e) {
			response.sendRedirect("fail.jsp");
			e.printStackTrace();
		}
	%>
	<br>
	<a href="index.jsp">返回</a>

</body>
</html>