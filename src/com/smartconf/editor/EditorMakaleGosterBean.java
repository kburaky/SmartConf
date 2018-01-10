package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editormakalegosterBean")
@SessionScoped
public class EditorMakaleGosterBean {
	
	public List<EditorMakaleGoster> getUserList() {
		List<EditorMakaleGoster> list = new ArrayList<EditorMakaleGoster>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			 
			String sql = "select * from makale ORDER BY makale_son_guncelleme DESC LIMIT 3";
			
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				EditorMakaleGoster usr = new EditorMakaleGoster();
				usr.setMakaleid(rs.getInt("makale_id"));
				usr.setMakaleozet(rs.getString("makale_ozet"));
				usr.setMakalebaslik(rs.getString("makale_baslik"));
				usr.setMakaleanahtarkelimeler(rs.getString("makale_anahtar_kelimeler"));			
				
				usr.setMakaleiceriktipi(rs.getString("makale_icerik_tipi"));
				usr.setMakalesonguncelleme(rs.getString("makale_son_guncelleme"));
				usr.setYazarkuladi(rs.getString("yazar_kul_adi"));
				
				
				list.add((EditorMakaleGoster) usr);
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
