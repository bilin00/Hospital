package com.yh.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import com.yh.bean.physician;
  
public class phDAO {
  
    public phDAO() {
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
  
            String sql = "select count(*) from physician;";
  
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
  
    public boolean add(physician ph) {
    	  
        String sql = "insert into physician values(?,?,?,?,?);";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
        	ps.setInt(1, ph.getPhid());
            ps.setString(2, ph.getPhfname());
            ps.setString(3, ph.getPhtel());
            ps.setString(4, ph.getPhspl());
            ps.setInt(5, ph.getHid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean update(physician ph) {
  
        String sql = "update physician set phfname = ?, phtel = ? , phspl =? , hospital_hid = ? where phid = ?;";
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setString(1, ph.getPhfname());
            ps.setString(2, ph.getPhtel());
            ps.setString(3, ph.getPhspl());
            ps.setInt(4, ph.getHid());
            ps.setInt(5, ph.getPhid());
  
            return ps.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
  
    public boolean delete(int phid) {
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "delete from physician where phid = " + phid;
  
            return s.executeUpdate(sql)>0;
            
        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }
  
    public physician get(int phid) {
        physician ph = null;
  
        try (Connection c = getConnection(); Statement s = c.createStatement();) {
  
            String sql = "select * from physician where phid = " + phid;
  
            ResultSet rs = s.executeQuery(sql);
  
            if (rs.next()) {
                ph = new physician();
                String phfname = rs.getString(2);
                String phtel = rs.getString(3);
                String phspl=rs.getString(4);
                int hid = rs.getInt(5);
                ph.setPhid(phid);
                ph.setPhfname(phfname);
                ph.setPhtel(phtel);
                ph.setPhspl(phspl);
                ph.setHid(hid);
            }
  
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return ph;
    }
  
    public List<physician> list() {
        return list(0, Short.MAX_VALUE, new String());
    }
  
    public List<physician> list(int start, int count, String sql) {
        List<physician> phs = new ArrayList<physician>();
  
        try (Connection c = getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
  
            ps.setInt(1, start);
            ps.setInt(2, count);
  
            ResultSet rs = ps.executeQuery();
  
            while (rs.next()) {
                physician ph = new physician();
                int phid = rs.getInt(1);
                String phfname = rs.getString(2);
                String phtel = rs.getString(3);
                String phspl=rs.getString(4);
                int hid = rs.getInt(5);
                ph.setPhid(phid);
                ph.setPhfname(phfname);
                ph.setPhtel(phtel);
                ph.setPhspl(phspl);
                ph.setHid(hid);
                phs.add(ph);
            }
        } catch (SQLException e) {
  
            e.printStackTrace();
        }
        return phs;
    }
  
}