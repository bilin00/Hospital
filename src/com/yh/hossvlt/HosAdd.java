package com.yh.hossvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.hospital;
import com.yh.jdbc.hosDAO;

public class HosAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 
	        hospital hos = new hospital();
	        hos.setHid(Integer.parseInt(request.getParameter("hid")));
	        hos.setHname(request.getParameter("hname"));
	        hos.setHst_address(request.getParameter("hst"));
	        hos.setHcity(request.getParameter("hcity"));
	        hos.setHstate(request.getParameter("hstate"));
	        hos.setHzip(Integer.parseInt(request.getParameter("hzip")));

	        PrintWriter out = response.getWriter();
			
			if (new hosDAO().add(hos)) {
				out.println ("<script language=javascript>confirm('The add succeeds!');window.location='HosList?main=yes'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The add fails!');window.location='HosList?main=yes'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
