package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "editorHakemBean")
@SessionScoped
public class EditorHakemBean {

public List<EditorHakem> getUserList() {
		
		List<EditorHakem> list = new ArrayList<EditorHakem>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			String sql = "select * from hakem";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				EditorHakem usr = new EditorHakem();
				
				usr.setHakemid(rs.getInt("hakem_id"));
				usr.setHakemadi(rs.getString("hakem_kul_adi"));
				usr.setHakemsifre(rs.getString("hakem_sifre"));
				usr.setHakemilkisim(rs.getString("hakem_ilk_isim"));
				usr.setHakemikinciisim(rs.getString("hakem_ikinci_isim"));
				usr.setHakemsoyisim(rs.getString("hakem_soyisim"));
				usr.setHakemuyelik(rs.getString("hakem_uyelik"));
				usr.setHakemtelefon(rs.getString("hakem_telefon"));
				usr.setHakememail(rs.getString("hakem_email"));
				usr.setHakemadres(rs.getString("hakem_adres"));
				usr.setHakemolusturmatarihi(rs.getString("hakem_olusturma_tarihi"));
				usr.setHakemuzmanlikalani(rs.getString("hakem_uzmanlik_alani"));
				
				
				//usr.setEditorolusturmatarihi(rs.getDate("editor_olusturma_tarihi"));
				
				list.add((EditorHakem) usr);
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
