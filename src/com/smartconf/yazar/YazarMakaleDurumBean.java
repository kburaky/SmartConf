package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.smartconf.editor.Atama;



@ManagedBean(name = "yazarMakaleDurumBean")
@SessionScoped
public class YazarMakaleDurumBean {

public List<Atama> getDurumList() {
		
		List<Atama> list = new ArrayList<Atama>();
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			
		   YazarBean nesne = new YazarBean();
			
		   int deneme = nesne.getUserList().get(0).getKullaniciid();
			

			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			
			String sql =
					"SELECT yazar_makale_durum.yazar_makale_durum_id , yazar_makale_durum.kullanici_id , yazar_makale_durum.makale_id , yazar_makale_durum.dosya_id , yazar_makale_durum.durum , yazar_makale_durum.nedeni FROM yazar_makale_durum " 
				   +"INNER JOIN kullanici  ON kullanici.kullanici_id = yazar_makale_durum.kullanici_id " 
				   +"WHERE yazar_makale_durum.kullanici_id= '"+deneme+"'  ";
			
			
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
				Atama usr = new Atama();
				
				usr.setYazarmakaledurumid(rs.getInt("yazar_makale_durum.yazar_makale_durum_id"));
				usr.setKullaniciid(rs.getInt("yazar_makale_durum.kullanici_id"));
				usr.setMakaleid(rs.getInt("yazar_makale_durum.makale_id"));
				usr.setDosyaid(rs.getInt("yazar_makale_durum.dosya_id"));	
				usr.setDurum(rs.getString("yazar_makale_durum.durum"));
				usr.setNedeni(rs.getString("yazar_makale_durum.nedeni"));
				
				
				list.add((Atama) usr);
				
				
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
