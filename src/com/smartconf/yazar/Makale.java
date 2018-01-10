package com.smartconf.yazar;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "makale")
@SessionScoped
public class Makale  {

	private int    makaleid;
	private String makaleozet;
	private String makalebaslik;
	private String makaleanahtarkelimeler;
	private String makaledurum;
	private String makaleorjinalhali;
	private String makaledosyaadi;
	private String makaleiceriktipi;
	private String makalesonguncelleme;
	private int konferansid;
	private int editorid;
	
	

	
	public int getEditorid() {
		return editorid;
	}

	public void setEditorid(int editorid) {
		this.editorid = editorid;
	}


	public int getMakaleid() {
		return makaleid;
	}


	public void setMakaleid(int makaleid) {
		this.makaleid = makaleid;
	}


	public String getMakaleozet() {
		return makaleozet;
	}


	public void setMakaleozet(String makaleozet) {
		this.makaleozet = makaleozet;
	}


	public String getMakalebaslik() {
		return makalebaslik;
	}


	public void setMakalebaslik(String makalebaslik) {
		this.makalebaslik = makalebaslik;
	}


	public String getMakaleanahtarkelimeler() {
		return makaleanahtarkelimeler;
	}


	public void setMakaleanahtarkelimeler(String makaleanahtarkelimeler) {
		this.makaleanahtarkelimeler = makaleanahtarkelimeler;
	}


	public String getMakaledurum() {
		return makaledurum;
	}


	public void setMakaledurum(String makaledurum) {
		this.makaledurum = makaledurum;
	}


	public String getMakaleorjinalhali() {
		return makaleorjinalhali;
	}


	public void setMakaleorjinalhali(String makaleorjinalhali) {
		this.makaleorjinalhali = makaleorjinalhali;
	}


	public String getMakaledosyaadi() {
		return makaledosyaadi;
	}


	public void setMakaledosyaadi(String makaledosyaadi) {
		this.makaledosyaadi = makaledosyaadi;
	}


	public String getMakaleiceriktipi() {
		return makaleiceriktipi;
	}


	public void setMakaleiceriktipi(String makaleiceriktipi) {
		this.makaleiceriktipi = makaleiceriktipi;
	}


	public String getMakalesonguncelleme() {
		return makalesonguncelleme;
	}


	public void setMakalesonguncelleme(String makalesonguncelleme) {
		this.makalesonguncelleme = makalesonguncelleme;
	}


	public int getKonferansid() {
		return konferansid;
	}


	public void setKonferansid(int konferansid) {
		this.konferansid = konferansid;
	}


	
	public void ekle(){			
		PreparedStatement ps = null;
		Connection con = null;

			try
    		{
				Util m =new Util();
				
				Date simdikiZaman = new Date();
   				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		        //System.out.println(df.format(simdikiZaman));
				
				
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO MAKALE (makale_ozet,makale_baslik,makale_anahtar_kelimeler,makale_icerik_tipi,makale_son_guncelleme,yazar_kul_adi) VALUES(?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, makaleozet);	
    			ps.setString(2, makalebaslik);
    			ps.setString(3, makaleanahtarkelimeler);
    		
    			ps.setString(4, makaleiceriktipi);
    			ps.setString(5, df.format(simdikiZaman));
    			ps.setString(6, m.getUserName());
    			//ps.setInt(7, editorid);
    			
    			
    				
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
        return "Makale Yollma Ýþlemi BASARILI!!!";
    }
	
	public String showBasarisiz() {
        return "Makale Yollma Ýþlemi BASARISIZ!!!";
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
    			String sql = "delete from makale where makale_id="+userID;
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
	