package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "makaleBean")
@SessionScoped
public class MakaleBean {

	
	public List<Makale> getUserList() {
		List<Makale> list = new ArrayList<Makale>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			Util m =new Util();
			//makale_ozet,makale_baslik,makale_anahtar_kelimeler,makale_orjinal_hali,makale_icerik_tipi,makale_son_guncelleme 
			String sql = "select * from makale "
					+ "where yazar_kul_adi = '"+m.getUserName()+"' "
					+"ORDER BY makale_son_guncelleme DESC LIMIT 1";
			
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Makale usr = new Makale();
				usr.setMakaleid(rs.getInt("makale_id"));
				usr.setMakaleozet(rs.getString("makale_ozet"));
				usr.setMakalebaslik(rs.getString("makale_baslik"));
				usr.setMakaleanahtarkelimeler(rs.getString("makale_anahtar_kelimeler"));			
				
				usr.setMakaleiceriktipi(rs.getString("makale_icerik_tipi"));
				usr.setMakalesonguncelleme(rs.getString("makale_son_guncelleme"));
				
				
				list.add((Makale) usr);
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
