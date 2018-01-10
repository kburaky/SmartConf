package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;



@ManagedBean(name = "yazar")
@SessionScoped
public class Yazar {
	
	private int    kullaniciid;
	private String kullaniciadi;
	private String kullanicisifre;
	private String kullaniciilkisim;
	private String kullaniciikinciisim;
	private String kullanicisoyisim;
	private String kullaniciuyelik;
	private String kullanicitelefon;
	private String kullaniciemail;
	private String kullaniciadres;
	private String kullaniciuzmanlikalani;
	
	
	public String getKullaniciuzmanlikalani() {
		return kullaniciuzmanlikalani;
	}




	public void setKullaniciuzmanlikalani(String kullaniciuzmanlikalani) {
		this.kullaniciuzmanlikalani = kullaniciuzmanlikalani;
	}


	private String makaleyazarkod;
	private String dosyaadi;
	
	

	public String getMakaleyazarkod() {
		return makaleyazarkod;
	}


	public void setMakaleyazarkod(String makaleyazarkod) {
		this.makaleyazarkod = makaleyazarkod;
	}


	public String getDosyaadi() {
		return dosyaadi;
	}


	public void setDosyaadi(String dosyaadi) {
		this.dosyaadi = dosyaadi;
	}


	public int getKullaniciid() {
		return kullaniciid;
	}


	public void setKullaniciid(int kullaniciid) {
		this.kullaniciid = kullaniciid;
	}


	public String getKullaniciadi() {
		return kullaniciadi;
	}


	public void setKullaniciadi(String kullaniciadi) {
		this.kullaniciadi = kullaniciadi;
	}


	public String getKullanicisifre() {
		return kullanicisifre;
	}


	public void setKullanicisifre(String kullanicisifre) {
		this.kullanicisifre = kullanicisifre;
	}


	public String getKullaniciilkisim() {
		return kullaniciilkisim;
	}


	public void setKullaniciilkisim(String kullaniciilkisim) {
		this.kullaniciilkisim = kullaniciilkisim;
	}


	public String getKullaniciikinciisim() {
		return kullaniciikinciisim;
	}


	public void setKullaniciikinciisim(String kullaniciikinciisim) {
		this.kullaniciikinciisim = kullaniciikinciisim;
	}


	public String getKullanicisoyisim() {
		return kullanicisoyisim;
	}


	public void setKullanicisoyisim(String kullanicisoyisim) {
		this.kullanicisoyisim = kullanicisoyisim;
	}


	public String getKullaniciuyelik() {
		return kullaniciuyelik;
	}


	public void setKullaniciuyelik(String kullaniciuyelik) {
		this.kullaniciuyelik = kullaniciuyelik;
	}


	public String getKullanicitelefon() {
		return kullanicitelefon;
	}


	public void setKullanicitelefon(String kullanicitelefon) {
		this.kullanicitelefon = kullanicitelefon;
	}


	public String getKullaniciemail() {
		return kullaniciemail;
	}


	public void setKullaniciemail(String kullaniciemail) {
		this.kullaniciemail = kullaniciemail;
	}


	public String getKullaniciadres() {
		return kullaniciadres;
	}


	public void setKullaniciadres(String kullaniciadres) {
		this.kullaniciadres = kullaniciadres;
	}

		
public void ekle2(){
		
		PreparedStatement ps = null;
		Connection con = null;
		
			try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO KULLANICI (kullanici_adi,kullanici_sifre,kullanici_ilk_isim,kullanici_ikinci_isim,kullanici_soyisim,kullanici_uyelik,kullanici_telefon,kullanici_email,kullanici_adres,kullanici_uzmanlik_alani) VALUES(?,?,?,?,?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, kullaniciadi);	
    			ps.setString(2, kullanicisifre);
    			ps.setString(3, kullaniciilkisim);
    			ps.setString(4, kullaniciikinciisim);
    			ps.setString(5, kullanicisoyisim);
    			ps.setString(6, kullaniciuyelik);
    			ps.setString(7, kullanicitelefon);
    			ps.setString(8, kullaniciemail);
    			ps.setString(9, kullaniciadres);
    			ps.setString(10, kullaniciuzmanlikalani);
				
				
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
	

	public void ekle(){
		
		PreparedStatement ps = null;
		Connection con = null;
		
			try
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "INSERT INTO DOSYA (makale_yazar_kod,dosya_adi) VALUES(?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, makaleyazarkod);	
    			ps.setString(2, dosyaadi);
				
				
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
	
	
	//GUNCELLEME METODU
	public void duzenle(int id)
	{
		PreparedStatement ps = null;
		Connection con = null;
		
		
			try
    		{
				//Util n =new Util();
				
    			Class.forName("com.mysql.jdbc.Driver");
    			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
    			String sql = "UPDATE  kullanici "
    					+ "SET kullanici_adi=?,"
    					+ "kullanici_sifre=?,"
    					+ "kullanici_ilk_isim=?,"
    					+ "kullanici_ikinci_isim=?,"
    					+ "kullanici_soyisim=?,"
    					+ "kullanici_uyelik=?,"
    					+ "kullanici_telefon=?,"
    					+ "kullanici_email=?,"
    					+ "kullanici_adres=?,"
    					+ "kullanici_uzmanlik_alani=? "
    					+ "WHERE kullanici_id = '"+id+"' ";
    			
    			ps= con.prepareStatement(sql);	
    			
    			ps.setString(1, kullaniciadi);	
    			ps.setString(2, kullanicisifre);
    			ps.setString(3, kullaniciilkisim);
    			ps.setString(4, kullaniciikinciisim);
    			ps.setString(5, kullanicisoyisim);
    			ps.setString(6, kullaniciuyelik);
    			ps.setString(7, kullanicitelefon);
    			ps.setString(8, kullaniciemail);
    			ps.setString(9, kullaniciadres);
    			ps.setString(10, kullaniciuzmanlikalani);
    			
    			
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
