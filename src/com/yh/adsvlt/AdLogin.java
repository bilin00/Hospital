package com.yh.adsvlt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.admin;
import com.yh.jdbc.adDAO;

public class AdLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String adname = request.getParameter("adname");
		
		String password = request.getParameter("password");
		
		admin ad = new admin();
		
		ad.setAdname(adname);
		
		if(!(new adDAO().get(ad))) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println ("<script language=javascript>alert('The username does not exit!');window.location='/admin/login.jsp'</script>");
		}
		else if(ad.getPassword().equals(password)) {
			request.getSession().setAttribute("validname", adname);
			response.sendRedirect("http://35.243.252.141/main.jsp");
		}
		else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println ("<script language=javascript>alert('The password is wrong!');window.location='/admin/login.jsp'</script>");
			}
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
