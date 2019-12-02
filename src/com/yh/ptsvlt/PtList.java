package com.yh.ptsvlt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.bean.patient_treatment;

import com.yh.jdbc.ptDAO;

public class PtList extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = null;
		
		String main = request.getParameter("main");
		String tdate = request.getParameter("tdate");
		String tfreq = request.getParameter("tfreq");
		String tstatus = request.getParameter("tstatus");
		String pid = request.getParameter("pid");
		String tid = request.getParameter("tid");
		String phid = request.getParameter("phid");
		String sql_option = request.getParameter("sql_option");
		String val = request.getParameter("val");
		
		if(sql_option!=null) {
			request.setAttribute("sql_option", sql_option);
			request.setAttribute("val", val);
			if(sql_option.equals("yes")) {
				sql = "select * from patient_treatment order by tdate desc limit ?,? ;";
			}
			else if(sql_option.equals("tdate")) {
				sql = "select * from patient_treatment where tdate = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("tfreq")) {
				sql = "select * from patient_treatment where tfreq = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("tstatus")) {
				sql = "select * from patient_treatment where tstatus = '" + val + "' limit ?,?";
			}
			else if(sql_option.equals("pid")) {
				sql = "select * from patient_treatment where patient_pid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("tid")) {
				sql = "select * from patient_treatment where treatment_tid = " + Integer.parseInt(val) + " limit ?,?";
			}
			else if(sql_option.equals("phid")) {
				sql = "select * from patient_treatment where physician_phid = " + Integer.parseInt(val) + " limit ?,?";
			}
		}
		else if(main!=null&&main.equals("yes")) {
			sql = "select * from patient_treatment order by tdate desc limit ?,? ;";
			request.setAttribute("sql_option", "yes");
		}
		else if(tdate!=null) {
			sql = "select * from patient_treatment where tdate = '" + tdate + "' limit ?,?";
			request.setAttribute("sql_option", "tdate");
			request.setAttribute("val", tdate);
		}
		else if(tfreq!=null) {
			sql = "select * from patient_treatment where tfreq = " + Integer.parseInt(tfreq) + " limit ?,?";
			request.setAttribute("sql_option", "tfreq");
			request.setAttribute("val", tfreq);
		}
		else if(tstatus!=null) {
			sql = "select * from patient_treatment where tstatus = '" + tstatus + "' limit ?,?";
			request.setAttribute("sql_option", "tstatus");
			request.setAttribute("val", tstatus);
		}
		else if(pid!=null) {
			sql = "select * from patient_treatment where patient_pid = " + Integer.parseInt(pid) + " limit ?,?";
			request.setAttribute("sql_option", "pid");
			request.setAttribute("val", pid);
		}
		else if(tid!=null) {
			sql = "select * from patient_treatment where treatment_tid = " + Integer.parseInt(tid) + " limit ?,?";
			request.setAttribute("sql_option", "tid");
			request.setAttribute("val", tid);
		}
		else if(phid!=null) {
			sql = "select * from patient_treatment where physician_phid = " + Integer.parseInt(phid) + " limit ?,?";
			request.setAttribute("sql_option", "phid");
			request.setAttribute("val", phid);
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
     
            int total = new ptDAO().getTotal();
     
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
            
			List<patient_treatment> pts = new ptDAO().list(start, count, sql);
			
			request.setAttribute("pts", pts);

		request.getRequestDispatcher("list/pt_list.jsp").forward(request, response);
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

