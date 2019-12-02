package com.yh.ussvlt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.jdbc.usDAO;

public class UsDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setAttribute("start", request.getParameter("start"));
		request.setAttribute("sql_option", request.getParameter("sql_option"));
		request.setAttribute("val", request.getParameter("val"));
		
		try {
			int uid = Integer.parseInt(request.getParameter("id"));
	        new usDAO().delete(uid);
		}
		catch(NumberFormatException e) {
			
		}
        
        request.getRequestDispatcher("UsList").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}