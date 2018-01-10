package com.smartconf.hakem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.smartconf.yazar.*;

@ManagedBean(name = "hakemMakaleBean")
@SessionScoped
public class HakemMakaleBean {

	
	public List<Makale> getMakaleList() {
		
		
		List<Makale> list = new ArrayList<Makale>();
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			
		   HakemBean nesne = new HakemBean();
		   int deneme = nesne.getUserList().get(0).getHakemid();
			

			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			
			String sql =
					"SELECT makale.makale_id , makale.makale_ozet , makale.makale_baslik , makale.makale_anahtar_kelimeler , makale.makale_icerik_tipi FROM makale " 
				   +"INNER JOIN hakem_makale  ON hakem_makale.makale_id = makale.makale_id " 
				   +"WHERE hakem_makale.hakem_id= '"+deneme+"' ORDER BY hakem_makale.hakem_id DESC LIMIT 1";
			
			
			
			
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
			
			    Makale usr = new Makale();
				
				usr.setMakaleid(rs.getInt("makale.makale_id"));
				usr.setMakaleozet(rs.getString("makale.makale_ozet"));
				usr.setMakalebaslik(rs.getString("makale.makale_baslik"));
				usr.setMakaleanahtarkelimeler(rs.getString("makale.makale_anahtar_kelimeler"));	
				
				usr.setMakaleiceriktipi(rs.getString("makale.makale_icerik_tipi"));
				
				
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
