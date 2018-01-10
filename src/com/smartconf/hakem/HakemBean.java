package com.smartconf.hakem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.smartconf.yazar.LoginBeanYazar;
import com.smartconf.yazar.Util;



@ManagedBean(name = "hakemBean")
@SessionScoped


public class HakemBean {
	
	public List<Hakem> getUserList() {
		List<Hakem> list = new ArrayList<Hakem>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			
			Utilm m =new Utilm();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			String sql = "select hakem_id,hakem_kul_adi,hakem_sifre,hakem_ilk_isim,hakem_ikinci_isim,hakem_soyisim,hakem_uyelik,hakem_telefon,hakem_email,hakem_adres,hakem_uzmanlik_alani from hakem"
					+ " where hakem_kul_adi = '"+m.getUserName()+"' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Hakem usr = new Hakem();
				
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
				usr.setHakemuzmanlikalani(rs.getString("hakem_uzmanlik_alani"));
				
				
				list.add((Hakem) usr);
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
	
	
	public void doSetUname() {
	    HttpSession session = Util.getSession();
	    String un = session.getAttribute("username").toString();
	    LoginBeanHakem t = new LoginBeanHakem();
	    t.setUname(un);
	  }
	

}

