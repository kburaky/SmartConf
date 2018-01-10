package com.smartconf.yazar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean(name = "dosya")
@SessionScoped
public class Dosya {
	
	private int dosyaid;
	private String yazarkullaniciadi;
	private String dosyaadi;
	private String tarih;
	private String durum;
	
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	public int getDosyaid() {
		return dosyaid;
	}
	public void setDosyaid(int dosyaid) {
		this.dosyaid = dosyaid;
	}
	public String getYazarkullaniciadi() {
		return yazarkullaniciadi;
	}
	public void setYazarkullaniciadi(String yazarkullaniciadi) {
		this.yazarkullaniciadi = yazarkullaniciadi;
	}
	public String getDosyaadi() {
		return dosyaadi;
	}
	public void setDosyaadi(String dosyaadi) {
		this.dosyaadi = dosyaadi;
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
    			String sql = "delete from dosya where dosya_id="+userID;
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
