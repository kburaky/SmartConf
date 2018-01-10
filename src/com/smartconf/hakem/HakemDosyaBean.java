package com.smartconf.hakem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.smartconf.yazar.Dosya;



@ManagedBean(name = "hakemDosyaBean")
@SessionScoped
public class HakemDosyaBean {

	
public List<Dosya> getDosyaList() {
		
		List<Dosya> list = new ArrayList<Dosya>();
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			
		   HakemBean nesne = new HakemBean();
			
		   int dene = nesne.getUserList().get(0).getHakemid();
			

			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			
			String sql =
					"SELECT dosya.dosya_id , dosya.yazar_kullanici_adi , dosya.dosya_adi , dosya.tarih  FROM dosya " 
				   +"INNER JOIN hakem_makale  ON hakem_makale.dosya_id = dosya.dosya_id " 
				   +"WHERE hakem_makale.hakem_id= '"+dene+"' ORDER BY hakem_makale.hakem_id DESC LIMIT 1";
			
			
			
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
				Dosya usr = new Dosya();
				
				usr.setDosyaid(rs.getInt("dosya.dosya_id"));
				usr.setYazarkullaniciadi(rs.getString("dosya.yazar_kullanici_adi"));
				usr.setDosyaadi(rs.getString("dosya.dosya_adi"));
				usr.setTarih(rs.getString("dosya.tarih"));	
				
				
				
				
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
