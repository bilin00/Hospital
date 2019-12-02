package com.yh.deptsvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.department;

import com.yh.jdbc.deptDAO;

public class DeptList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String did = request.getParameter("did");
		String dname = request.getParameter("dname");
		String dtel = request.getParameter("dtel");
		String hid = request.getParameter("hid");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from department order by did desc limit ?,? ;";
			}
			else if(sql_option.equals("did")) {
				sql = "select * from department where did = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("dname")) {
				sql = "select * from department where dname = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("dtel")) {
				sql = "select * from department where dtel = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("hid")) {
				sql = "select * from department where hospital_hid = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from department order by did desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(did!=null) {
			sql = "select * from department where did = " + Integer.parseInt(did) + " limit ?,?";
			request.setAttribute("sql_option", "did");
			request.setAttribute("val", did);
		}
		else if(dname!=null) {
			sql = "select * from department where dname = '" + dname + "' limit ?,?";
			request.setAttribute("sql_option", "dname");
			request.setAttribute("val", dname);
		}
		else if(dtel!=null) {
			sql = "select * from department where dtel = '" + dtel + "' limit ?,?";
			request.setAttribute("sql_option", "dtel");
			request.setAttribute("val", dtel);
		}
		else if(hid!=null) {
			sql = "select * from department where hospital_hid = " + Integer.parseInt(hid) + " limit ?,?";
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
     
            int total = new deptDAO().getTotal();
     
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
            
			List<department> depts = new deptDAO().list(start, count, sql);
			
			request.setAttribute("depts", depts);

		request.getRequestDispatcher("list/dept_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

