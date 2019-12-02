package com.yh.ptsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.patient_treatment;
import com.yh.jdbc.ptDAO;

public class PtUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 
			patient_treatment pt = new patient_treatment();       
	        pt.setTdate(request.getParameter("tdate"));
	        pt.setTfreq(Integer.parseInt(request.getParameter("tfreq")));
	        pt.setTstatus(request.getParameter("tstatus"));
	        pt.setPid(Integer.parseInt(request.getParameter("pid")));
	        pt.setTid(Integer.parseInt(request.getParameter("tid")));
	        pt.setPhid(Integer.parseInt(request.getParameter("phid")));

	        PrintWriter out = response.getWriter();
			
			if (new ptDAO().update(pt)) {
				out.println ("<script language=javascript>confirm('The update succeeds!');window.location='PtList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The update fails!');window.location='PtList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
