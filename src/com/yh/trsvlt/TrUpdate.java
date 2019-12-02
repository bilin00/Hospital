package com.yh.trsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.treatment;
import com.yh.jdbc.trDAO;

public class TrUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	        treatment tr = new treatment();
	        tr.setTid(Integer.parseInt(request.getParameter("tid")));
	        tr.setTname(request.getParameter("tname"));
	        tr.setTtype(request.getParameter("ttype"));
	        tr.setDeid(Integer.parseInt(request.getParameter("deid")));

	        PrintWriter out = response.getWriter();
			
			if (new trDAO().update(tr)) {
				out.println ("<script language=javascript>confirm('The update succeeds!');window.location='TrList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The update fails!');window.location='TrList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
