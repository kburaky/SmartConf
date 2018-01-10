package com.smartconf.editor;

import java.sql.*;

public class UserDAO { 
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/smartconf";

	   //  Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	
	
	
     public static boolean login(String user, String password) {
    	 
        Connection con = null;
        PreparedStatement ps = null;
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	con = DriverManager.getConnection(DB_URL, USER, PASS);
            ps = con.prepareStatement(
                    "SELECT editor_kul_adi, editor_sifre FROM editor WHERE editor_kul_adi= ? and editor_sifre= ? ");
            ps.setString(1, user);
            ps.setString(2, password);
 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
            	
                //System.out.println(rs.getString("kullanici_adi"));
                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());
            return false;
        } finally {
        	//DriverManager.close(con);
        }
    }
}
