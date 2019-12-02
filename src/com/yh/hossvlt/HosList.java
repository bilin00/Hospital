package com.yh.hossvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.hospital;

import com.yh.jdbc.hosDAO;

public class HosList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String hid = request.getParameter("hid");
		String hname = request.getParameter("hname");
		String hst_address = request.getParameter("hst_address");
		String hcity = request.getParameter("hcity");
		String hstate = request.getParameter("hstate");
		String hzip = request.getParameter("hzip");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from hospital order by hid desc limit ?,? ;";
			}
			else if(sql_option.equals("hid")) {
				sql = "select * from hospital where hid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("hname")) {
				sql = "select * from hospital where hname = " + val + " limit ?,?";
			}
			else if(sql_option.equals("hst_address")) {
				sql = "select * from hospital where hst_address = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("hcity")) {
				sql = "select * from hospital where hcity = " + val + " limit ?,?";
			}
			else if(sql_option.equals("hstate")) {
				sql = "select * from hospital where hstate = " + val + " limit ?,?";
			}
			else if(sql_option.equals("hzip")) {
				sql = "select * from hospital where hzip = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from hospital order by hid desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(hid!=null) {
			sql = "select * from hospital where hid = " + Integer.parseInt(hid) + " limit ?,?";
			request.setAttribute("sql_option", "hid");
			request.setAttribute("val", hid);
		}
		else if(hname!=null) {
			sql = "select * from hospital where hname = " + hname + " limit ?,?";
			request.setAttribute("sql_option", "hname");
			request.setAttribute("val", hname);
		}
		else if(hst_address!=null) {
			sql = "select * from hospital where hst_address = '" + hst_address + "' limit ?,?";
			request.setAttribute("sql_option", "hst_address");
			request.setAttribute("val", hst_address);
		}
		else if(hcity!=null) {
			sql = "select * from hospital where hcity = " + hcity + " limit ?,?";
			request.setAttribute("sql_option", "hcity");
			request.setAttribute("val", hcity);
		}
		else if(hstate!=null) {
			sql = "select * from hospital where hstate = " + hstate + " limit ?,?";
			request.setAttribute("sql_option", "hstate");
			request.setAttribute("val", hstate);
		}
		else if(hzip!=null) {
			sql = "select * from hospital where hzip = " + Integer.parseInt(hzip) + " limit ?,?";
			request.setAttribute("sql_option", "hzip");
			request.setAttribute("val", hzip);
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
     
            int total = new hosDAO().getTotal();
     
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
            
			List<hospital> hoss = new hosDAO().list(start, count, sql);
			
			request.setAttribute("hoss", hoss);

		request.getRequestDispatcher("list/hos_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

