package com.smartconf.editor;

import java.sql.*;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "tableBeanc")
@SessionScoped
public class TableBeanc {

	Connection con;
	Statement ps;
	ResultSet rs;
	private List<perInfo> perInfoAll = new ArrayList<perInfo>();

	public List<perInfo> getperInfoAll() {
		int k = 0;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf","root","root");
			ps = con.createStatement();
			rs = ps.executeQuery("select count(kullanici_id) from kullanici");
			while (rs.next()) {
				//System.out.println(rs.getString(1));
				perInfoAll.add(k, new perInfo(rs.getString(1)));
				k++;
				

			}
			
			con.close();
			rs.close();
			ps.close();
			

		} catch (Exception e) {
			System.out.println("Error Data : " + e.getMessage());
		}
		return perInfoAll;
	}

	public class perInfo {

		String kid;

		public perInfo(String uname) {
			this.kid = uname;
		}

		public String getKid() {
			return kid;
		}

	}

}
