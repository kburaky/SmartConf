package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editormakalebildirBean")
@SessionScoped
public class EditorMakaleBildirBean {

	public List<Atama> getUserList() {
		
		
		List<Atama> list = new ArrayList<Atama>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
						
			String sql = "select * from yazar_makale_durum ORDER BY yazar_makale_durum_id DESC LIMIT 3";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Atama usr = new Atama();
				
				usr.setYazarmakaledurumid(rs.getInt("yazar_makale_durum_id"));
				usr.setKullaniciid(rs.getInt("kullanici_id"));
				usr.setMakaleid(rs.getInt("makale_id"));
				usr.setDosyaid(rs.getInt("dosya_id"));
				usr.setDurum(rs.getString("durum"));
				usr.setNedeni(rs.getString("nedeni"));
				
		    
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
