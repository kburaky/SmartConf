package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "konferans")
@SessionScoped
public class Konferans {

	private int    konferansid;
	private String konferansadi;
	private String konferansaciklama;
	private String konferanskonu;
	private String konferansyer;
	private String konferansbaslangictarihi;
	private String konferansbitistarihi;
	private String konferansurl;
	public int getKonferansid() {
		return konferansid;
	}
	public void setKonferansid(int konferansid) {
		this.konferansid = konferansid;
	}
	public String getKonferansadi() {
		return konferansadi;
	}
	public void setKonferansadi(String konferansadi) {
		this.konferansadi = konferansadi;
	}
	public String getKonferansaciklama() {
		return konferansaciklama;
	}
	public void setKonferansaciklama(String konferansaciklama) {
		this.konferansaciklama = konferansaciklama;
	}
	public String getKonferanskonu() {
		return konferanskonu;
	}
	public void setKonferanskonu(String konferanskonu) {
		this.konferanskonu = konferanskonu;
	}
	public String getKonferansyer() {
		return konferansyer;
	}
	public void setKonferansyer(String konferansyer) {
		this.konferansyer = konferansyer;
	}
	public String getKonferansbaslangictarihi() {
		return konferansbaslangictarihi;
	}
	public void setKonferansbaslangictarihi(String konferansbaslangictarihi) {
		this.konferansbaslangictarihi = konferansbaslangictarihi;
	}
	public String getKonferansbitistarihi() {
		return konferansbitistarihi;
	}
	public void setKonferansbitistarihi(String konferansbitistarihi) {
		this.konferansbitistarihi = konferansbitistarihi;
	}
	public String getKonferansurl() {
		return konferansurl;
	}
	public void setKonferansurl(String konferansurl) {
		this.konferansurl = konferansurl;
	}
	

	
//DÜZENLE 
	public void ekle(){
				
		PreparedStatement ps = null;
		Connection con = null;
		
			try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO KONFERANS (konferans_isim,konferans_aciklama,konferans_konu,konferans_yer,konferans_baslangic_tarih,konferans_bitis_tarih,konferans_url) VALUES(?,?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, konferansadi);	
    			ps.setString(2, konferansaciklama);
    			ps.setString(3, konferanskonu);
    			ps.setString(4, konferansyer);
    			ps.setString(5, konferansbaslangictarihi);
    			ps.setString(6, konferansbitistarihi);
    			ps.setString(7, konferansurl);
				
				
    			int i = ps.executeUpdate();
    			if(i >0){  		 			
	    			System.out.println("KAYIT BASARILI");
	    			showBasarili();
    			}
				
    			
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			System.out.println("HATA: "+e);
    			showBasarisiz();
    		}
    		finally
    		{
    			try
    			{
    			con.close();
    			ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
		}
	

	public String showBasarili() {
        return "KAYIT BASARILI";
    }
	
	public String showBasarisiz() {
        return "KAYIT BASARISIZ";
    }
	

	public void delete(int userID)
	{
		PreparedStatement ps = null;
		Connection con = null;
		if(userID !=0)
		{
			try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "delete from konferans where konferans_id="+userID;
    			ps= con.prepareStatement(sql);		
    			int i = ps.executeUpdate();
    			if(i >0)
    			{  			
    			System.out.println("Row deleted successfully");
    		  }
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    			System.out.println("HATA : "+e);
    		}
    		finally
    		{
    			try
    			{
    			con.close();
    			ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
		}
	}
	

	public void duzenle(int userID)
	{
		PreparedStatement ps = null;
		Connection con = null;
		if(userID !=0)
		{
			try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "UPDATE  editor SET editor_kul_adi=?,editor_sifre=?,editor_ilk_isim=?,editor_ikinci_isim=?,editor_soyisim=?,editor_uyelik=?,editor_telefon=?,editor_email=?,editor_adres=? WHERE editor_id="+userID;
    			ps= con.prepareStatement(sql);		
    			int i = ps.executeUpdate();
    			if(i >0)
    			{  			
    			System.out.println("Row deleted successfully");
    		  }
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}
    		finally
    		{
    			try
    			{
    			con.close();
    			ps.close();
    			}
    			catch(Exception e)
    			{
    				e.printStackTrace();
    			}
    		}
		}
	}
	

	
	}
	