package com.yh.disvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.disease;
import com.yh.jdbc.diDAO;

public class DiAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 
	        disease di = new disease();
	        di.setDeid(Integer.parseInt(request.getParameter("deid")));
	        di.setDename(request.getParameter("dename"));

	        PrintWriter out = response.getWriter();
			
			if (new diDAO().add(di)) {
				out.println ("<script language=javascript>confirm('The add succeeds!');window.location='DiList?main=yes'</script>");
			}
			else {
				out.println ("<script language=javascript>alert('The add fails!');window.location='DiList?main=yes'</script>");
			}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
