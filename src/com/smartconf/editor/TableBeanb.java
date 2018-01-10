package com.smartconf.editor;

import java.sql.*;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "tableBeanb")
@SessionScoped

public class TableBeanb {

	Connection con;
	Statement ps;
	ResultSet rs;
	
	private List<perInfo> perInfoAll = new ArrayList<perInfo>() ;

	
	public List<perInfo> getPerInfoAll() {
		
		 try
		  {
			  
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf","root","root");
		     ps = con.createStatement();
			 rs = ps.executeQuery("select count(konferans_id) from konferans");
			while(rs.next())
			  {
				//System.out.println(rs.getString(1));
				perInfoAll.add(new perInfo(rs.getString(1)));
							
			  }
			con.close();
			rs.close();
			ps.close();

		  }
		  catch (Exception e)
		  {
			  System.out.println("Error Data : " + e.getMessage());
			  
		  }
		return perInfoAll;
	}
	

	public class perInfo {

		String eid;

		public perInfo(String yname) {
			this.eid = yname;
		}

		public String getEid() {
			return eid;
		}

		
	}
	

}
