package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yh.bean.disease;
  
public class diDAO {
  
    public diDAO() {
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
  
            String sql = "select count(*) from disease;";
  
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
  
    public boolean add(disease di) {
    	  
        String sql = "insert into disease values(?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, di.getDeid());
            ps.setString(2, di.getDename());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(disease di) {
  
        String sql = "update disease set dename= ? where deid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, di.getDename());
            ps.setInt(2, di.getDeid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int deid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from disease where deid = " + deid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public disease get(int deid) {
        disease di = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from disease where deid = " + deid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                di = new disease();
                String dename = rs.getString(2);
                di.setDeid(deid);
                di.setDename(dename);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return di;
    }
  
    public List<disease> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<disease> list(int start, int count, String sql) {
        List<disease> dis = new ArrayList<disease>();
        
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                disease di = new disease();
                int deid = rs.getInt(1);
                String dename = rs.getString(2);
                di.setDeid(deid);
                di.setDename(dename);
                dis.add(di);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return dis;
    }
  
}