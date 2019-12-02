package com.yh.pasvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.patient;

import com.yh.jdbc.paDAO;

public class PaList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String pid = request.getParameter("pid");
		String pfname = request.getParameter("pfname");
		String plname = request.getParameter("plname");
		String pgender = request.getParameter("pgender");
		String pbd = request.getParameter("pbd");
		String prace = request.getParameter("prace");
		String pstatus = request.getParameter("pstatus");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from patient order by pid desc limit ?,? ;";
			}
			else if(sql_option.equals("pid")) {
				sql = "select * from patient where pid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("pfname")) {
				sql = "select * from patient where pfname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("plname")) {
				sql = "select * from patient where plname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("pgender")) {
				sql = "select * from patient where pgender = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("pbd")) {
				sql = "select * from patient where pbd = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("prace")) {
				sql = "select * from patient where prace = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("pstatus")) {
				sql = "select * from patient where pstatus = '" + val + "' limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
	        sql = "select * from patient order by pid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(pid!=null) {
			sql = "select * from patient where pid = " + Integer.parseInt(pid) + " limit ?,?";
			request.setAttribute("sql_option", "pid");
			request.setAttribute("val", pid);
		}
		else if(pfname!=null) {
			sql = "select * from patient where pfname = '" + pfname + "' limit ?,?";
			request.setAttribute("sql_option", "pfname");
			request.setAttribute("val", pfname);
		}
		else if(plname!=null) {
			sql = "select * from patient where plname = '" + plname + "' limit ?,?";
			request.setAttribute("sql_option", "plname");
			request.setAttribute("val", plname);
		}
		else if(pgender!=null) {
			sql = "select * from patient where pgender = '" + pgender + "' limit ?,?";
			request.setAttribute("sql_option", "pgender");
			request.setAttribute("val", pgender);
		}
		else if(pbd!=null) {
			sql = "select * from patient where pbd = '" + pbd + "' limit ?,?";
			request.setAttribute("sql_option", "pbd");
			request.setAttribute("val", pbd);
		}
		else if(prace!=null) {
			sql = "select * from patient where prace = '" + prace + "' limit ?,?";
			request.setAttribute("sql_option", "prace");
			request.setAttribute("val", prace);
		}
		else if(pstatus!=null) {
			sql = "select * from patient where pstatus = '" + pstatus + "' limit ?,?";
			request.setAttribute("sql_option", "pstatus");
			request.setAttribute("val", pstatus);
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
     
            int total = new paDAO().getTotal();
     
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
            
			List<patient> pas = new paDAO().list(start, count, sql);
			
			request.setAttribute("pas", pas);

		request.getRequestDispatcher("list/pa_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

