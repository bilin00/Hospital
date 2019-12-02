package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.users;
  
public class usDAO {
  
    public usDAO() {
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
  
            String sql = "select count(*) from users;";
  
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
  
    public boolean add(users us) {
  
        String sql = "insert into users values(?,?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, us.getUid());
            ps.setString(2, us.getUfname());
            ps.setString(3, us.getUlname());
            ps.setString(4, us.getUrole());
            ps.setInt(5, us.getDid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(users us) {
  
        String sql = "update users set ufname = ?, ulname = ? , urole =? , department_did = ? where uid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, us.getUfname());
            ps.setString(2, us.getUlname());
            ps.setString(3, us.getUrole());
            ps.setInt(4, us.getDid());
            ps.setInt(5, us.getUid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int uid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from users where uid = " + uid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public users get(int uid) {
        users us = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from users where uid = " + uid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                us = new users();
                String ufname = rs.getString(2);
                String ulname = rs.getString(3);
                String urole=rs.getString(4);
                int did = rs.getInt(5);
                us.setUid(uid);
                us.setUfname(ufname);
                us.setUlname(ulname);
                us.setUrole(urole);
                us.setDid(did);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return us;
    }
  
    public List<users> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<users> list(int start, int count, String sql) {
        List<users> uss = new ArrayList<users>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                users us = new users();
                int uid = rs.getInt(1);
                String ufname = rs.getString(2);
                String ulname = rs.getString(3);
                String urole=rs.getString(4);
                int did = rs.getInt(5);
                us.setUid(uid);
                us.setUfname(ufname);
                us.setUlname(ulname);
                us.setUrole(urole);
                us.setDid(did);
                uss.add(us);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return uss;
    }
  
}