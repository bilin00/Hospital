package com.yh.disvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.disease;

import com.yh.jdbc.diDAO;

public class DiList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String deid = request.getParameter("deid");
		String dename = request.getParameter("dename");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from disease order by deid desc limit ?,? ;";
			}
			else if(sql_option.equals("deid")) {
				sql = "select * from disease where deid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("dename")) {
				sql = "select * from disease where dename = '" + val + "' limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from disease order by deid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(deid!=null) {
			sql = "select * from disease where deid = " + Integer.parseInt(deid) + " limit ?,?";
			request.setAttribute("sql_option", "deid");
			request.setAttribute("val", deid);
		}
		else if(dename!=null) {
			sql = "select * from disease where dename = '" + dename + "' limit ?,?";
			request.setAttribute("sql_option", "dename");
			request.setAttribute("val", dename);
		}
		
			int start = 0;
			int count = 8;
            
            try {
                start = Integer.parseInt(request.getParameter("start"));
            } catch (NumberFormatException e) {
                // 当浏览器没有传参数start时
            }
            
            int next = start + count;
            int pre = start - count;
     
            int total = new diDAO().getTotal();
     
            int last;
            if (0 == total % count)
                last = total - count;
            else
                last = total - total % count;
     
            pre = pre < 0 ? 0 : pre;
            next = next > last ? last : next;
     
            request.setAttribute("start", start);
            request.setAttribute("next", next);
            request.setAttribute("pre", pre);
            request.setAttribute("last", last);
            
			List<disease> dis = new diDAO().list(start, count, sql);
			
			request.setAttribute("dis", dis);

		request.getRequestDispatcher("list/di_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

