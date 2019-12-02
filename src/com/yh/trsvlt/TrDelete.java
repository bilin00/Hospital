package com.yh.trsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.jdbc.trDAO;

public class TrDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int tid = Integer.parseInt(request.getParameter("id"));
			
			PrintWriter out = response.getWriter();
			
			if (new trDAO().delete(tid)) {
				out.println ("<script language=javascript>confirm('The delete succeeds!');window.location='TrList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The delete fails!');window.location='TrList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}