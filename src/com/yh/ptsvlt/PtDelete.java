package com.yh.ptsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.jdbc.ptDAO;

public class PtDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String tdate = request.getParameter("tdate");
			int tfreq = Integer.parseInt(request.getParameter("tfreq"));
			int pid = Integer.parseInt(request.getParameter("pid"));
			int tid = Integer.parseInt(request.getParameter("tid"));
			int phid = Integer.parseInt(request.getParameter("phid"));
	            
	        PrintWriter out = response.getWriter();
			
			if (new ptDAO().delete(tdate, tfreq, pid, tid, phid)) {
				out.println ("<script language=javascript>confirm('The delete succeeds!');window.location='PtList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The delete fails!');window.location='PtList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}