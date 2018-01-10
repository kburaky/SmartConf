package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "dosyaBean")
@SessionScoped

public class DosyaBean {

	
	public List<Dosya> getUserList() {
		
		List<Dosya> list = new ArrayList<Dosya>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			Util m =new Util();
		
			
			String sql = "select * from dosya "
					    +"where yazar_kullanici_adi = '"+m.getUserName()+"' "
					    +"ORDER BY tarih DESC LIMIT 1";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Dosya usr = new Dosya();
				
				usr.setDosyaid(rs.getInt("dosya_id"));
				usr.setYazarkullaniciadi(rs.getString("yazar_kullanici_adi"));
				usr.setDosyaadi(rs.getString("dosya_adi"));
				usr.setTarih(rs.getString("tarih"));
				usr.setDurum(rs.getString("durum"));
				
				
				
				list.add((Dosya) usr);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	
}
