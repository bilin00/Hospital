package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.department;
  
public class deptDAO {
  
    public deptDAO() {
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
  
            String sql = "select count(*) from department;";
  
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
  
    public boolean add(department dept) {
  
        String sql = "insert into department values(?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, dept.getDid());
            ps.setString(2, dept.getDname());
            ps.setString(3, dept.getDtel());
            ps.setInt(4, dept.getHospital_hid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean update(department dept) {
  
        String sql = "update department set dname= ?, dtel = ? , hospital_hid = ? where did = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, dept.getDname());
            ps.setString(2, dept.getDtel());
            ps.setInt(3, dept.getHospital_hid());
            ps.setInt(4, dept.getDid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int did) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from department where did = " + did;
  
            return s.executeUpdate(sql)>0;
  
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public department get(int did) {
        department dept = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from department where did = " + did;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                dept = new department();
                String dname = rs.getString(2);
                String dtel = rs.getString(3);
                int hospital_hid = rs.getInt(4);
                dept.setDid(did);
                dept.setDname(dname);
                dept.setDtel(dtel);
                dept.setHospital_hid(hospital_hid);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return dept;
    }
  
    public List<department> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<department> list(int start, int count, String sql) {
        List<department> depts = new ArrayList<department>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                department dept = new department();
                int did = rs.getInt(1);
                String dname = rs.getString(2);
                String dtel = rs.getString(3);
                int hospital_hid = rs.getInt(4);
                dept.setDid(did);
                dept.setDname(dname);
                dept.setDtel(dtel);
                dept.setHospital_hid(hospital_hid);
                depts.add(dept);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return depts;
    }
  
}