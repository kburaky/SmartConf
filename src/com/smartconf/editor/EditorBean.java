package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editorBean")
@SessionScoped
public class EditorBean {

	List<Editor> liste = new ArrayList<Editor>();
	
	
	 public List<Editor> getAllAcyears() {
		    String sql = "SELECT editor_id, editor_kul_adi FROM editor;";
		    List<Editor> data = new ArrayList<Editor>();
		    PreparedStatement ps = null;
			Connection con = null;
			ResultSet rs = null;
		    try {
		    	Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/smartconf", "root", "root");
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
		      while (rs.next()) {
		    	  Editor acyb = new Editor();
		        acyb.setEditorid(rs.getInt("editor_id"));
		        acyb.setEditorkullaniciadi(rs.getString("editor_kul_adi"));
		        acyb.setEditorsifre(rs.getString("editor_sifre"));
		        acyb.setEditorilkisim(rs.getString("editor_ilk_isim"));
		        acyb.setEditorikinciisim(rs.getString("editor_ikinci_isim"));
		        acyb.setEditorsoyisim(rs.getString("editor_soyisim"));
		        acyb.setEditoruyelik(rs.getString("editor_uyelik"));
		        acyb.setEditortelefon(rs.getString("editor_telefon"));
		        acyb.setEditoremail(rs.getString("editor_email"));
		        acyb.setEditoradres(rs.getString("editor_adres"));
		        
		        
		        data.add(acyb);
		      }
		    } catch (Exception e) {
		    }

		    return data;
		  }
	 
	public List<Editor> getUserList() {
		List<Editor> list = new ArrayList<Editor>();
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			String sql = "select * from editor";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Editor usr = new Editor();
				usr.setEditorkullaniciadi(rs.getString("editor_kul_adi"));
				usr.setEditorsifre(rs.getString("editor_sifre"));
				usr.setEditorilkisim(rs.getString("editor_ilk_isim"));
				usr.setEditorikinciisim(rs.getString("editor_ikinci_isim"));
				usr.setEditorsoyisim(rs.getString("editor_soyisim"));
				usr.setEditoruyelik(rs.getString("editor_uyelik"));
				usr.setEditortelefon(rs.getString("editor_telefon"));
				usr.setEditoremail(rs.getString("editor_email"));
				usr.setEditoradres(rs.getString("editor_adres"));
				//usr.setEditorolusturmatarihi(rs.getDate("editor_olusturma_tarihi"));
				
				list.add((Editor) usr);
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
	
	
	
	
	
	public boolean Guncelle()// Güncellemeyi veri tabanýna aktaracak metod.
	{
		
		Connection con = null;
		ResultSet rs = null;
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/smartconf", "root", "root");
			PreparedStatement ps = con
					.prepareStatement("UPDATE editor SET editor_kul_adi=?,editor_sifre=?,editor_ilk_isim=?,editor_ikinci_isim=?,editor_soyisim=?,editor_uyelik=?,editor_telefon=?,editor_email=?,editor_adres=? WHERE editor_id=?");
			
			for (Editor item : liste)
			// liste içindeki adý,alaný ve ID kýsýmlarýný kullanmak için böyle
			// bir döngü tanýmladýk.
			{
				ps.setString(1, item.getEditorkullaniciadi());
				ps.setString(2, item.getEditorsifre());
				ps.setString(3, item.getEditorilkisim());
				ps.setString(4, item.getEditorikinciisim());
				ps.setString(5, item.getEditorsoyisim());
				ps.setString(6, item.getEditoruyelik());
				ps.setString(7, item.getEditortelefon());
				ps.setString(8, item.getEditoremail());
				ps.setString(9, item.getEditoradres());
				ps.setInt(10, item.getEditorid());
				i = ps.executeUpdate();// Ýþlem baþarýlý olursa i 0'dan büyük
										// deðer alýr. Olmazsa küçük deðer alýr.
			}
		} catch (Exception e) {
			System.err.print(e);
		}
		if (i > 0)
			return true;// Ýþlemin baþarýlý olmasý durumunda true döner.
		else
			return false;// Baþarýsýz olma durumunda false döner.
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
