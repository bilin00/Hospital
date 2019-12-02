package com.yh.ussvlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.users;

import com.yh.jdbc.usDAO;

public class UsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		request.setAttribute("start", request.getParameter("start"));
		request.setAttribute("sql_option", request.getParameter("sql_option"));
		request.setAttribute("val", request.getParameter("val"));
		
		try {
	        users us = new users();
	        us.setUid(Integer.parseInt(request.getParameter("uid")));
	        us.setUfname(request.getParameter("ufname"));
	        us.setUlname(request.getParameter("ulname"));
	        us.setUrole(request.getParameter("urole"));
	        us.setDid(Integer.parseInt(request.getParameter("did")));

			if (new usDAO().update(us)) {
				// 更新成输出信息
				request.getRequestDispatcher("UsList").forward(request, response);
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
