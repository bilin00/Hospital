package com.yh.disvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.jdbc.diDAO;

public class DiDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int deid = Integer.parseInt(request.getParameter("id"));
			
			PrintWriter out = response.getWriter();
			
			if (new diDAO().delete(deid)) {
				out.println ("<script language=javascript>confirm('The delete succeeds!');window.location='DiList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The delete fails!');window.location='DiList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}