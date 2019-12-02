package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.treatment;
  
public class trDAO {
  
    public trDAO() {
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
  
            String sql = "select count(*) from treatment;";
  
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
  
    public boolean add(treatment tr) {
  
        String sql = "insert into treatment values(?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, tr.getTid());
            ps.setString(2, tr.getTname());
            ps.setString(3, tr.getTtype());
            ps.setInt(4, tr.getDeid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(treatment tr) {
  
        String sql = "update treatment set tname= ?, ttype = ? , disease_deid = ? where tid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, tr.getTname());
            ps.setString(2, tr.getTtype());
            ps.setInt(3, tr.getDeid());
            ps.setInt(4, tr.getTid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int tid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from treatment where tid = " + tid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public treatment get(int tid) {
        treatment tr = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from treatment where tid = " + tid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                tr = new treatment();
                String tname = rs.getString(2);
                String ttype = rs.getString(3);
                int deid = rs.getInt(4);
                tr.setDeid(deid);
                tr.setTname(tname);
                tr.setTtype(ttype);
                tr.setTid(tid);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return tr;
    }
  
    public List<treatment> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<treatment> list(int start, int count, String sql) {
        List<treatment> trs = new ArrayList<treatment>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                treatment tr = new treatment();
                int tid = rs.getInt(1);
                String tname = rs.getString(2);
                String ttype = rs.getString(3);
                int deid = rs.getInt(4);
                tr.setDeid(deid);
                tr.setTname(tname);
                tr.setTtype(ttype);
                tr.setTid(tid);
                trs.add(tr);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return trs;
    }
  
}