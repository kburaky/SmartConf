package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editorYazarBean")
@SessionScoped


public class EditorYazarBean {

	public List<EditorYazar> getUserList() {
		
		List<EditorYazar> list = new ArrayList<EditorYazar>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
		
			String sql = "select * from kullanici";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EditorYazar usr = new EditorYazar();
				
				usr.setKullaniciid(rs.getInt("kullanici_id"));
				usr.setKullaniciadi(rs.getString("kullanici_adi"));
				usr.setKullanicisifre(rs.getString("kullanici_sifre"));
				usr.setKullaniciilkisim(rs.getString("kullanici_ilk_isim"));
				usr.setKullaniciikinciisim(rs.getString("kullanici_ikinci_isim"));
				usr.setKullanicisoyisim(rs.getString("kullanici_soyisim"));
				usr.setKullaniciuyelik(rs.getString("kullanici_uyelik"));
				usr.setKullanicitelefon(rs.getString("kullanici_telefon"));
				usr.setKullaniciemail(rs.getString("kullanici_email"));
				usr.setKullaniciadres(rs.getString("kullanici_adres"));
			    usr.setKullaniciuzmanlikalani(rs.getString("kullanici_uzmanlik_alani"));
				
			    
				list.add((EditorYazar) usr);
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
