<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ע��</title>
</head>
<body>
<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		try {
			// �������ݿ�������ע�ᵽ����������
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&useSSL=false";
			// ���ݿ��û���
			String us = "root";
			// ���ݿ�����
			String pw = "123456";
			// ����Connection����
			Connection conn = DriverManager.getConnection(url, us,
					pw);
			String sql = "select * from tb_mima where username='"+name+"'";
			
			 // ִ�в�ѯ��䣬���ѽ�������ظ�ResultSet
            ResultSet rs = s.executeQuery(sql);
			// �ж��Ƿ���³ɹ�
			if (rs.next()) {
				// ��ע���
				out.print("<font color='red'>The username has been registered!</font>");
				out.print("<script>document.getElementById("btn-login").disabled = true</script>");
			}
			// �ر�PreparedStatement���ͷ���Դ
			ps.close();
			// �ر�Connection���ͷ���Դ
			conn.close();
		} catch (Exception e) {
			out.print("��Ϣ��Ѱʧ�ܣ�");
			e.printStackTrace();
		}
	%>
	<br>
</body>
</html>