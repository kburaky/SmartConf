package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editorHakem")
@SessionScoped
public class EditorHakem {
	
	private int    hakemid;
	private String hakemadi;
	private String hakemsifre;
	private String hakemilkisim;
	private String hakemikinciisim;
	private String hakemsoyisim;
	private String hakemuyelik;
	private String hakemtelefon;
	private String hakememail;
	private String hakemadres;
	private String hakemolusturmatarihi;
	private String hakemuzmanlikalani;

	
public String getHakemolusturmatarihi() {
		return hakemolusturmatarihi;
	}

	public void setHakemolusturmatarihi(String hakemolusturmatarihi) {
		this.hakemolusturmatarihi = hakemolusturmatarihi;
	}

public String getHakemuzmanlikalani() {
		return hakemuzmanlikalani;
	}

	public void setHakemuzmanlikalani(String hakemuzmanlikalani) {
		this.hakemuzmanlikalani = hakemuzmanlikalani;
	}

public int getHakemid() {
		return hakemid;
	}

	public void setHakemid(int hakemid) {
		this.hakemid = hakemid;
	}


	public String getHakemadi() {
		return hakemadi;
	}


	public void setHakemadi(String hakemadi) {
		this.hakemadi = hakemadi;
	}


	public String getHakemsifre() {
		return hakemsifre;
	}


	public void setHakemsifre(String hakemsifre) {
		this.hakemsifre = hakemsifre;
	}


	public String getHakemilkisim() {
		return hakemilkisim;
	}


	public void setHakemilkisim(String hakemilkisim) {
		this.hakemilkisim = hakemilkisim;
	}


	public String getHakemikinciisim() {
		return hakemikinciisim;
	}


	public void setHakemikinciisim(String hakemikinciisim) {
		this.hakemikinciisim = hakemikinciisim;
	}


	public String getHakemsoyisim() {
		return hakemsoyisim;
	}


	public void setHakemsoyisim(String hakemsoyisim) {
		this.hakemsoyisim = hakemsoyisim;
	}


	public String getHakemuyelik() {
		return hakemuyelik;
	}


	public void setHakemuyelik(String hakemuyelik) {
		this.hakemuyelik = hakemuyelik;
	}


	public String getHakemtelefon() {
		return hakemtelefon;
	}


	public void setHakemtelefon(String hakemtelefon) {
		this.hakemtelefon = hakemtelefon;
	}


	public String getHakememail() {
		return hakememail;
	}


	public void setHakememail(String hakememail) {
		this.hakememail = hakememail;
	}


	public String getHakemadres() {
		return hakemadres;
	}




	public void setHakemadres(String hakemadres) {
		this.hakemadres = hakemadres;
	}




public void ekle2(){
		
		PreparedStatement ps = null;
		Connection con = null;
		
			try
    		{
				
				Date simdikiZaman = new Date();
   				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO HAKEM (hakem_kul_adi,hakem_sifre,hakem_ilk_isim,hakem_ikinci_isim,hakem_soyisim,hakem_uyelik,hakem_telefon,hakem_email,hakem_adres,hakem_olusturma_tarihi,hakem_uzmanlik_alani) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, hakemadi);	
    			ps.setString(2, hakemsifre);
    			ps.setString(3, hakemilkisim);
    			ps.setString(4, hakemikinciisim);
    			ps.setString(5, hakemsoyisim);
    			ps.setString(6, hakemuyelik);
    			ps.setString(7, hakemtelefon);
    			ps.setString(8, hakememail);
    			ps.setString(9, hakemadres);
    			ps.setString(10, df.format(simdikiZaman));
    			ps.setString(11, hakemuzmanlikalani);
				
				
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
    			String sql = "delete from hakem where hakem_id="+userID;
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
	
	
}
