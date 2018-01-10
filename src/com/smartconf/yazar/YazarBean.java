package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.smartconf.editor.Editor;



@ManagedBean(name = "yazarBean")
@SessionScoped


public class YazarBean {
	
	
	public List<Yazar> bilgileriGetir(int deger){
		List<Yazar> list = new ArrayList<Yazar>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			
			
			String sql = "select kullanici_id,kullanici_adi,kullanici_sifre,kullanici_ilk_isim,kullanici_ikinci_isim,kullanici_soyisim,kullanici_uyelik,kullanici_telefon,kullanici_email,kullanici_adres,kullanici_uzmanlik_alani from kullanici "
					    + "where kullanici_id = '"+deger+"' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Yazar usr = new Yazar();
				
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
				
				list.add((Yazar) usr);
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
	
	
	public List<Yazar> getUserList() {
		List<Yazar> list = new ArrayList<Yazar>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			
			
			Util m =new Util();
			
			String sql = "select kullanici_id,kullanici_adi,kullanici_sifre,kullanici_ilk_isim,kullanici_ikinci_isim,kullanici_soyisim,kullanici_uyelik,kullanici_telefon,kullanici_email,kullanici_adres,kullanici_uzmanlik_alani from kullanici "
					+ "where kullanici_adi = '"+m.getUserName()+"' ";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				Yazar usr = new Yazar();
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
			
				
				
				
				list.add((Yazar) usr);
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
	    LoginBeanYazar t = new LoginBeanYazar();
	    t.setUname(un);
	  }
	
	
}
