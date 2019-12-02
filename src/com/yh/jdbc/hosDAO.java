package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.hospital;
  
public class hosDAO {
  
    public hosDAO() {
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
  
            String sql = "select count(*) from hospital;";
  
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
  
    public boolean add(hospital hos) {
    	  
        String sql = "insert into hospital values(?,?,?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, hos.getHid());
            ps.setString(2, hos.getHname());
            ps.setString(3, hos.getHst_address());
            ps.setString(4, hos.getHcity());
            ps.setString(5, hos.getHstate());
            ps.setInt(6, hos.getHzip());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(hospital hos) {
  
        String sql = "update hospital set hname = ? , hst_address = ? , hst_city = ? , hstate = ? , hzip = ? where hid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(6, hos.getHid());
            ps.setString(1, hos.getHname());
            ps.setString(2, hos.getHst_address());
            ps.setString(3, hos.getHcity());
            ps.setString(4, hos.getHstate());
            ps.setInt(5, hos.getHzip());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int hid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from hospital where hid = " + hid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public hospital get(int hid) {
        hospital hos = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from hospital where hid = " + hid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                hos = new hospital();
                String hname = rs.getString(2);
                String hst_address = rs.getString(3);
                String hcity=rs.getString(4);
                String hstate=rs.getString(5);
                int hzip = rs.getInt(6);
                hos.setHid(hid);
                hos.setHname(hname);
                hos.setHst_address(hst_address);
                hos.setHcity(hcity);
                hos.setHstate(hstate);
                hos.setHzip(hzip);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return hos;
    }
  
    public List<hospital> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<hospital> list(int start, int count, String sql) {
        List<hospital> hoss = new ArrayList<hospital>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                hospital hos = new hospital();
                int hid = rs.getInt(1);
                String hname = rs.getString(2);
                String hst_address = rs.getString(3);
                String hcity=rs.getString(4);
                String hstate=rs.getString(5);
                int hzip = rs.getInt(6);
                hos.setHid(hid);
                hos.setHname(hname);
                hos.setHst_address(hst_address);
                hos.setHcity(hcity);
                hos.setHstate(hstate);
                hos.setHzip(hzip);
                hoss.add(hos);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return hoss;
    }
  
}