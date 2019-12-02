package com.yh.phsvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.physician;

import com.yh.jdbc.phDAO;

public class PhList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String phid = request.getParameter("phid");
		String phfname = request.getParameter("phfname");
		String phtel = request.getParameter("phtel");
		String phspl = request.getParameter("phspl");
		String hid = request.getParameter("hid");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from physician order by phid desc limit ?,? ;";
			}
			else if(sql_option.equals("phid")) {
				sql = "select * from physician where phid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("phfname")) {
				sql = "select * from physician where phfname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("phtel")) {
				sql = "select * from physician where phtel = " + val + " limit ?,?";
			}
			else if(sql_option.equals("phspl")) {
				sql = "select * from physician where phspl = " + val + " limit ?,?";
			}
			else if(sql_option.equals("hid")) {
				sql = "select * from physician where hid = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from physician order by phid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(phid!=null) {
			sql = "select * from physician where phid = " + Integer.parseInt(phid) + " limit ?,?";
			request.setAttribute("sql_option", "phid");
			request.setAttribute("val", phid);
		}
		else if(phfname!=null) {
			sql = "select * from physician where phfname = '" + phfname + "' limit ?,?";
			request.setAttribute("sql_option", "phfname");
			request.setAttribute("val", phfname);
		}
		else if(phtel!=null) {
			sql = "select * from physician where phtel = " + phtel + " limit ?,?";
			request.setAttribute("sql_option", "phtel");
			request.setAttribute("val", phtel);
		}
		else if(phspl!=null) {
			sql = "select * from physician where phspl = " + phspl + " limit ?,?";
			request.setAttribute("sql_option", "phspl");
			request.setAttribute("val", phspl);
		}
		else if(hid!=null) {
			sql = "select * from physician where hid = " + Integer.parseInt(hid) + " limit ?,?";
			request.setAttribute("sql_option", "hid");
			request.setAttribute("val", hid);
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
     
            int total = new phDAO().getTotal();
     
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
            
			List<physician> phs = new phDAO().list(start, count, sql);
			
			request.setAttribute("phs", phs);

		request.getRequestDispatcher("list/ph_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

