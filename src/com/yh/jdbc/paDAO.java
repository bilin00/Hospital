package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yh.bean.patient;
  
public class paDAO {
  
    public paDAO() {
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
  
            String sql = "select count(*) from patient;";
  
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
  
    public boolean add(patient pa) {
  	  
        String sql = "insert into patient values(?,?,?,?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, pa.getPid());
            ps.setString(2, pa.getPfname());
            ps.setString(3, pa.getPlname());
            ps.setString(4, pa.getPgender());
            ps.setString(5, pa.getPbd());
            ps.setString(6, pa.getPrace());
            ps.setString(7, pa.getPstatus());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(patient pa) {
  
        String sql = "update patient set pfname = ? , plname = ? , pgender = ? , pbd = ? , prace = ? , pstatus = ? where pid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(7, pa.getPid());
            ps.setString(1, pa.getPfname());
            ps.setString(2, pa.getPlname());
            ps.setString(3, pa.getPgender());
            ps.setString(4, pa.getPbd());
            ps.setString(5, pa.getPrace());
            ps.setString(6, pa.getPstatus());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int pid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from patient where pid = " + pid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public patient get(int pid) {
        patient pa = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from patient where pid = " + pid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                pa = new patient();
                pa.setPid(rs.getInt(1));
                pa.setPfname(rs.getString(2));
                pa.setPlname(rs.getString(3));
                pa.setPgender(rs.getString(4));
                pa.setPbd(rs.getString(5));
                pa.setPrace(rs.getString(6));
                pa.setPstatus(rs.getString(7));
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return pa;
    }
  
    public List<patient> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<patient> list(int start, int count, String sql) {
        List<patient> pas = new ArrayList<patient>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                patient pa = new patient();
                pa.setPid(rs.getInt(1));
                pa.setPfname(rs.getString(2));
                pa.setPlname(rs.getString(3));
                pa.setPgender(rs.getString(4));
                pa.setPbd(rs.getString(5));
                pa.setPrace(rs.getString(6));
                pa.setPstatus(rs.getString(7));
                pas.add(pa);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return pas;
    }
  
}