package com.yh.phsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.physician;
import com.yh.jdbc.phDAO;

public class PhAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 
	        physician ph = new physician();
	        ph.setPhid(Integer.parseInt(request.getParameter("phid")));
	        ph.setPhfname(request.getParameter("phfname"));
	        ph.setPhtel("phtel");
	        ph.setPhspl(request.getParameter("phspl"));
	        ph.setHid(Integer.parseInt(request.getParameter("hid")));

	        PrintWriter out = response.getWriter();
			
			if (new phDAO().add(ph)) {
				out.println ("<script language=javascript>confirm('The add succeeds!');window.location='PhList?main=yes'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The add fails!');window.location='PhList?main=yes'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
