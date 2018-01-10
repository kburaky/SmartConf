package com.smartconf.editor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "editor")
@SessionScoped
public class Editor {

	private int    editorid;
	private String editorkullaniciadi;
	private String editorsifre;
	private String editorilkisim;
	private String editorikinciisim;
	private String editorsoyisim;
	private String editoruyelik;
	private String editortelefon;
	private String editoremail;
	private String editoradres;
	private Date   editorolusturmatarihi;
	boolean guncellenebilirlik;
	
	
	 public boolean isGuncellenebilirlik() {
	       return guncellenebilirlik;
	 }
	 
	 public void setGuncellenebilirlik(boolean guncellenebilirlik) {
	       this.guncellenebilirlik = guncellenebilirlik;
	 }
	
	
	
	public int getEditorid() {
		return editorid;
	}
	public void setEditorid(int editorid) {
		this.editorid = editorid;
	}

	public String getEditorkullaniciadi() {
		return editorkullaniciadi;
	}
	public void setEditorkullaniciadi(String editorkullaniciadi) {
		this.editorkullaniciadi = editorkullaniciadi;
	}

	public String getEditorsifre() {
		return editorsifre;
	}
	public void setEditorsifre(String editorsifre) {
		this.editorsifre = editorsifre;
	}

	public String getEditorilkisim() {
		return editorilkisim;
	}
	public void setEditorilkisim(String editorilkisim) {
		this.editorilkisim = editorilkisim;
	}

	public String getEditorikinciisim() {
		return editorikinciisim;
	}
	public void setEditorikinciisim(String editorikinciisim) {
		this.editorikinciisim = editorikinciisim;
	}

	public String getEditorsoyisim() {
		return editorsoyisim;
	}
	public void setEditorsoyisim(String editorsoyisim) {
		this.editorsoyisim = editorsoyisim;
	}

	public String getEditoruyelik() {
		return editoruyelik;
	}
	public void setEditoruyelik(String editoruyelik) {
		this.editoruyelik = editoruyelik;
	}

	public String getEditortelefon() {
		return editortelefon;
	}
	public void setEditortelefon(String editortelefon) {
		this.editortelefon = editortelefon;
	}

	public String getEditoremail() {
		return editoremail;
	}
	public void setEditoremail(String editoremail) {
		this.editoremail = editoremail;
	}

	public String getEditoradres() {
		return editoradres;
	}
	public void setEditoradres(String editoradres) {
		this.editoradres = editoradres;
	}

    public Date getEditorolusturmatarihi() {
		return editorolusturmatarihi;
	}
	public void setEditorolusturmatarihi(Date editorolusturmatarihi) {
		this.editorolusturmatarihi = editorolusturmatarihi;
	}


	public void ekle(){
				
		PreparedStatement ps = null;
		Connection con = null;
		
			try
    		{
    			Class.forName("org.postgresql.Driver");
    			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/smartcity", "postgres", "root");
    			String sql = "INSERT INTO \"Etkinlik\" (eadi, eaciklama,esaat,eucret,ekontenjan,etarih) VALUES(?,?,?,?,?,?)";
    			ps= con.prepareStatement(sql);		
    			ps.setString(1, editorkullaniciadi);	
    			ps.setString(2, editorilkisim);
    			ps.setString(3, editorikinciisim);
    			ps.setString(4, editorsoyisim);
    			ps.setString(5, editoruyelik);
    			ps.setString(6, editortelefon);
				
				
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
    			Class.forName("org.postgresql.Driver");
    			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/smartcity", "postgres", "root");
    			String sql = "DELETE FROM \"Etkinlik\" WHERE eid="+userID;
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
    			String sql = "UPDATE  editor SET editor_kul_adi=?,editor_sifre=?,editor_ilk_isim=?,editor_ikinci_isim=?,editor_soyisim=?,editor_uyelik=?,editor_telefon=?,editor_email=?,editor_adres=? WHERE editor_id = "+userID;
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
	