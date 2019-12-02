package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.patient_treatment;
  
public class ptDAO {
  
    public ptDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
  
    public Connection getConnection() throws SQLException {
    	//链接数据库的url hero为数据库名
    	String url = "jdbc:mysql://127.0.0.1:3306/mydb?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    			//数据库用户
    			String user = "root";
    			//数据库密码/在这里输入数据库密码
    			String password = "123456";
    	
        return (Connection) DriverManager.getConnection(url, user, password);
    }
  
    public int getTotal() {
        int total = 0;
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select count(*) from patient_treatment;";
  
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
  
            System.out.println("total:" + total);
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return total;
    }
  
    public boolean add(patient_treatment pt) {
  
        String sql = "insert into patient_treatment values(?,?,?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, pt.getTdate());
            ps.setInt(2, pt.getTfreq());
            ps.setString(3, pt.getTstatus());
            ps.setInt(4, pt.getPid());
            ps.setInt(5, pt.getTid());
            ps.setInt(6, pt.getPhid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(patient_treatment pt) {
  
        String sql = "update patient_treatment set tstatus = ? where tdate = ? and tfreq = ? and patient_pid = ? and treatment_tid = ? and physician_phid = ? ";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(2, pt.getTdate());
            ps.setInt(3, pt.getTfreq());
            ps.setString(1, pt.getTstatus());
            ps.setInt(4, pt.getPid());
            ps.setInt(5, pt.getTid());
            ps.setInt(6, pt.getPhid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(String tdate, int tfreq, int pid, int tid, int phid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from patient_treatment where tdate = '" + tdate + "' and tfreq = " + tfreq + 
            		" and patient_pid = " + pid + " and treatment_tid = " + tid + " and physician_phid = " + phid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  /*
    public patient_treatment get(int pid) {
        patient_treatment pt = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from patient_treatment where pid = " + pid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                pt = new patient_treatment();
                String pfname = rs.getString(2);
                String plname = rs.getString(3);
                String pgender = rs.getString(4);
                String pbd=rs.getString(5);
                String prace=rs.getString(6);
                String pstatus = rs.getString(7);
                pt.setPid(pid);
                pt.setPfname(pfname);
                pt.setPlname(plname);
                pt.setPgender(pgender);
                pt.setPbd(pbd);
                pt.setPrace(prace);
                pt.setPstatus(pstatus);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return pt;
    }
    */ 
    
    public List<patient_treatment> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<patient_treatment> list(int start, int count, String sql) {
        List<patient_treatment> pts = new ArrayList<patient_treatment>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                patient_treatment pt = new patient_treatment();
                pt.setTdate(rs.getString(1));
                pt.setTfreq(rs.getInt(2));
                pt.setTstatus(rs.getString(3));
                pt.setPid(rs.getInt(4));
                pt.setTid(rs.getInt(5));
                pt.setPhid(rs.getInt(6));
                pts.add(pt);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return pts;
    }
}