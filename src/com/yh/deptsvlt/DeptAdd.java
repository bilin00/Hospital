package com.yh.deptsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.department;

import com.yh.jdbc.deptDAO;

public class DeptAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	        department dept = new department();
	        dept.setDid(Integer.parseInt(request.getParameter("did")));
	        dept.setDname(request.getParameter("dname"));
	        dept.setDtel(request.getParameter("dtel"));
	        dept.setHospital_hid(Integer.parseInt(request.getParameter("hid")));
	        
			PrintWriter out = response.getWriter();
			
			if (new deptDAO().add(dept)) {
				out.println ("<script language=javascript>confirm('The add succeeds!');window.location='DeptList?main=yes'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The add fails!');window.location='DeptList?main=yes'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
