package com.yh.deptsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.jdbc.deptDAO;

public class DeptDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int did = Integer.parseInt(request.getParameter("id"));
		
		PrintWriter out = response.getWriter();
		
		if (new deptDAO().delete(did)) {
			out.println ("<script language=javascript>confirm('The delete succeeds!');window.location='DeptList?start="
		+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
		+"&val="+request.getParameter("val")+"'</script>");
		}
		else {
			out.println ("<script language=javascript>alert('The delete fails!');window.location='DeptList?start="
		+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
		+"&val="+request.getParameter("val")+"'</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}