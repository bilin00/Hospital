package com.yh.hossvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.hospital;
import com.yh.jdbc.hosDAO;

public class HosUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
			hospital hos = new hospital();
	        hos.setHid(Integer.parseInt(request.getParameter("hid")));
	        hos.setHname(request.getParameter("hname"));
	        hos.setHst_address("hst");
	        hos.setHcity(request.getParameter("hcity"));
	        hos.setHstate("hstate");
	        hos.setHzip(Integer.parseInt(request.getParameter("hzip")));

	        PrintWriter out = response.getWriter();
			
			if (new hosDAO().update(hos)) {
				out.println ("<script language=javascript>confirm('The update succeeds!');window.location='HosList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The update fails!');window.location='HosList?start="
			+request.getParameter("start")+"&sql_option="+request.getParameter("sql_option")
			+"&val="+request.getParameter("val")+"'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
