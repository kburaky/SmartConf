package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editorDosyaBean")
@SessionScoped
public class EditorDosyaBean {
	
public List<EditorDosya> getUserList() {
		
		List<EditorDosya> list = new ArrayList<EditorDosya>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
				
			String sql = "select * from dosya ORDER BY tarih DESC LIMIT 3";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				EditorDosya usr = new EditorDosya();
				
				usr.setDosyaid(rs.getInt("dosya_id"));
				usr.setYazarkullaniciadi(rs.getString("yazar_kullanici_adi"));
				usr.setDosyaadi(rs.getString("dosya_adi"));
				usr.setTarih(rs.getString("tarih"));
						
				list.add((EditorDosya) usr);
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
