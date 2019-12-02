package com.yh.adsvlt;
  
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.admin;

import com.yh.jdbc.adDAO;

public class AdAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		 
		try {
	        admin ad = new admin();
	        ad.setAdname(request.getParameter("adname"));
	        ad.setPassword(request.getParameter("password"));

			if (new adDAO().add(ad)) {
				// 更新成输出信息
				response.sendRedirect("/admin/rsuc.jsp");
			}
			else
				response.sendRedirect("op_fail.jsp");
		} catch (Exception e) {
			response.sendRedirect("op_fail.jsp");
			e.printStackTrace();
		}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
