package com.yh.pasvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.patient;
import com.yh.jdbc.paDAO;

public class PaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
	        patient pa = new patient();
	        pa.setPid(Integer.parseInt(request.getParameter("pid")));
	        pa.setPfname(request.getParameter("pfname"));
	        pa.setPlname(request.getParameter("plname"));
	        pa.setPgender(request.getParameter("pgender"));	    
	        pa.setPbd(request.getParameter("pbd"));
	        pa.setPrace(request.getParameter("prace"));
	        pa.setPstatus(request.getParameter("pstatus"));

	        PrintWriter out = response.getWriter();
			
			if (new paDAO().update(pa)) {
				out.println ("<script language=javascript>confirm('The update succeeds!');window.location='PaList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The update fails!');window.location='PaList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
