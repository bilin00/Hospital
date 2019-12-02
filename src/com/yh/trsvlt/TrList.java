package com.yh.trsvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.treatment;

import com.yh.jdbc.trDAO;

public class TrList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String tid = request.getParameter("tid");
		String tname = request.getParameter("tname");
		String ttype = request.getParameter("ttype");
		String deid = request.getParameter("deid");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from treatment order by tid desc limit ?,? ;";
			}
			else if(sql_option.equals("tid")) {
				sql = "select * from treatment where tid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("tname")) {
				sql = "select * from treatment where tname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("ttype")) {
				sql = "select * from treatment where ttype = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("deid")) {
				sql = "select * from treatment where disease_deid = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from treatment order by tid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(tid!=null) {
			sql = "select * from treatment where tid = " + Integer.parseInt(tid) + " limit ?,?";
			request.setAttribute("sql_option", "tid");
			request.setAttribute("val", tid);
		}
		else if(tname!=null) {
			sql = "select * from treatment where tname = '" + tname + "' limit ?,?";
			request.setAttribute("sql_option", "tname");
			request.setAttribute("val", tname);
		}
		else if(ttype!=null) {
			sql = "select * from treatment where ttype = '" + ttype + "' limit ?,?";
			request.setAttribute("sql_option", "ttype");
			request.setAttribute("val", ttype);
		}
		else if(deid!=null) {
			sql = "select * from treatment where disease_deid = " + Integer.parseInt(deid) + " limit ?,?";
			request.setAttribute("sql_option", "deid");
			request.setAttribute("val", deid);
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
     
            int total = new trDAO().getTotal();
     
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
            
			List<treatment> trs = new trDAO().list(start, count, sql);
			
			request.setAttribute("trs", trs);

		request.getRequestDispatcher("list/tr_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

