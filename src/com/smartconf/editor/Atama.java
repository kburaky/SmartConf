package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "atama")
@SessionScoped
public class Atama {

	
	private int hakemgeridonusid;
	private int yazarmakaledurumid;
	private int makaleid;
	private int dosyaid;
	private int hakemid;
	private int kullaniciid;
	private String durum;
	private String nedeni;
	
	
	public int getYazarmakaledurumid() {
		return yazarmakaledurumid;
	}
	public void setYazarmakaledurumid(int yazarmakaledurumid) {
		this.yazarmakaledurumid = yazarmakaledurumid;
	}
	public int getHakemgeridonusid() {
		return hakemgeridonusid;
	}
	public void setHakemgeridonusid(int hakemgeridonusid) {
		this.hakemgeridonusid = hakemgeridonusid;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public String getNedeni() {
		return nedeni;
	}
	public void setNedeni(String nedeni) {
		this.nedeni = nedeni;
	}
	public int getKullaniciid() {
		return kullaniciid;
	}
	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}
	public int getMakaleid() {
		return makaleid;
	}
	public void setMakaleid(int makaleid) {
		this.makaleid = makaleid;
	}
	public int getDosyaid() {
		return dosyaid;
	}
	public void setDosyaid(int dosyaid) {
		this.dosyaid = dosyaid;
	}
	public int getHakemid() {
		return hakemid;
	}
	public void setHakemid(int hakemid) {
		this.hakemid = hakemid;
	}
	

	public void atamaekle(){
		
		PreparedStatement ps = null;
		Connection con = null;

			try
    		{
				
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO hakem_makale (makale_id,dosya_id,hakem_id,kullanici_id) VALUES(?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setInt(1,makaleid );
    			ps.setInt(2,dosyaid );
    			ps.setInt(3,hakemid );
    			ps.setInt(4,kullaniciid );
    			
			
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
	

	//hakemin makaleyi degerlendirip editöre gönderdigi kýsým
public void geridonus(){
		
		PreparedStatement ps = null;
		Connection con = null;

			try
    		{
				
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO hakem_geri_donus (kullanici_id,makale_id,dosya_id,hakem_id,durum,nedeni) VALUES(?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setInt(1,kullaniciid );
    			ps.setInt(2,makaleid );
    			ps.setInt(3,dosyaid );
    			ps.setInt(4,hakemid );
    			ps.setString(5,durum );
    			ps.setString(6,nedeni );
    			
		
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
	
public void yazarmakaledurum(){
	
	PreparedStatement ps = null;
	Connection con = null;

		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
			String sql = "INSERT INTO yazar_makale_durum (kullanici_id,makale_id,dosya_id,durum,nedeni) VALUES(?,?,?,?,?)";
			ps= con.prepareStatement(sql);		
			ps.setInt(1,kullaniciid );
			ps.setInt(2,makaleid );
			ps.setInt(3,dosyaid );
			ps.setString(4,durum );
			ps.setString(5,nedeni );
			
			
			
				
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
        return "Editöre Yollama Ýþlemi BASARILI!!!";
    }
	
	public String showBasarisiz() {
        return "Editöre Yollama Ýþlemi  BASARISIZ!!!";
    }
	
	public String yazarmakaleshowBasarili() {
        return "Makale Geri Donus Ýþlemi BASARILI!!!";
    }
	
	public String yazarmakaleshowBasarisiz() {
        return "Makale Geri Donus Ýþlemi BASARISIZ!!!";
    }
	
	public String hakemmakaleshowBasarili() {
        return "Hakeme Makale Gönderim  BASARILI!!!";
    }
	
	public String hakemmakaleshowBasarisiz() {
        return "Makale Makale Gönderim BASARISIZ!!!";
    }
	
}