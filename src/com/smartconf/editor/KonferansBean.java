package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "konferansBean")
@SessionScoped
public class KonferansBean {
	
	public List<Konferans> getUserList() {
		List<Konferans> list = new ArrayList<Konferans>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			String sql = "select * from konferans";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Konferans usr = new Konferans();
				
				usr.setKonferansid(rs.getInt("konferans_id"));
				usr.setKonferansadi(rs.getString("konferans_isim"));
				usr.setKonferansaciklama(rs.getString("konferans_aciklama"));
				usr.setKonferanskonu(rs.getString("konferans_konu"));
				usr.setKonferansyer(rs.getString("konferans_yer"));
				usr.setKonferansbaslangictarihi(rs.getString("konferans_baslangic_tarih"));
				usr.setKonferansbitistarihi(rs.getString("konferans_bitis_tarih"));
				usr.setKonferansurl(rs.getString("konferans_url"));
				
				
				
				list.add((Konferans) usr);
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
