package com.yh.ussvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.users;

import com.yh.jdbc.usDAO;

public class UsList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String uid = request.getParameter("uid");
		String ufname = request.getParameter("ufname");
		String ulname = request.getParameter("ulname");
		String urole = request.getParameter("urole");
		String did = request.getParameter("did");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from users order by uid desc limit ?,? ;";
			}
			else if(sql_option.equals("uid")) {
				sql = "select * from users where uid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("ufname")) {
				sql = "select * from users where ufname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("ulname")) {
				sql = "select * from users where ulname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("urole")) {
				sql = "select * from users where urole = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("did")) {
				sql = "select * from users where department_did = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from users order by uid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(uid!=null) {
			sql = "select * from users where uid = " + Integer.parseInt(uid) + " limit ?,?";
			request.setAttribute("sql_option", "uid");
			request.setAttribute("val", uid);
		}
		else if(ufname!=null) {
			sql = "select * from users where ufname = '" + ufname + "' limit ?,?";
			request.setAttribute("sql_option", "ufname");
			request.setAttribute("val", ufname);
		}
		else if(ulname!=null) {
			sql = "select * from users where ulname = '" + ulname + "' limit ?,?";
			request.setAttribute("sql_option", "ulname");
			request.setAttribute("val", ulname);
		}
		else if(urole!=null) {
			sql = "select * from users where urole = '" + urole + "' limit ?,?";
			request.setAttribute("sql_option", "urole");
			request.setAttribute("val", urole);
		}
		else if(did!=null) {
			sql = "select * from users where department_did = " + Integer.parseInt(did) + " limit ?,?";
			request.setAttribute("sql_option", "did");
			request.setAttribute("val", did);
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
     
            int total = new usDAO().getTotal();
     
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
            
			List<users> uss = new usDAO().list(start, count, sql);
			
			request.setAttribute("uss", uss);

		request.getRequestDispatcher("list/us_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

