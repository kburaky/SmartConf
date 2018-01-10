package com.smartconf.editor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "yonlendirme")
@SessionScoped

public class Yonlendirme {


	public List<EditorYazar> getYazarVerileri() {
	    
		
		String sql = "SELECT kullanici_id, kullanici_adi FROM kullanici;";
	    List<EditorYazar> data = new ArrayList<EditorYazar>();
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
	    	  EditorYazar acyb = new EditorYazar();
	        acyb.setKullaniciid(rs.getInt("kullanici_id"));
	        acyb.setKullaniciadi(rs.getString("kullanici_adi"));
	        data.add(acyb);
	      }
	    } catch (Exception e) {
	    }

	    return data;
	  }
	
	//-------------------------------------------------------------------
	public List<EditorMakaleGoster> getMakaleVerileri() {
	    String sql = "SELECT * FROM makale ORDER BY makale_son_guncelleme DESC LIMIT 3";
	    List<EditorMakaleGoster> data = new ArrayList<EditorMakaleGoster>();
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
	    	  EditorMakaleGoster acyb = new EditorMakaleGoster();
	        acyb.setMakaleid(rs.getInt("makale_id"));
	        acyb.setMakalebaslik(rs.getString("makale_baslik"));
	        data.add(acyb);
	      }
	    } catch (Exception e) {
	    }

	    return data;
	  }
	
	//-----------------------------------------------------------------------------
	
	public List<EditorDosya> getDosyaVerileri() {
	    String sql = "SELECT * FROM dosya ORDER BY tarih DESC LIMIT 3";
	    List<EditorDosya> data = new ArrayList<EditorDosya>();
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
	    	  EditorDosya acyb = new EditorDosya();
	        acyb.setDosyaid(rs.getInt("dosya_id"));
	        acyb.setDosyaadi(rs.getString("dosya_adi"));
	        data.add(acyb);
	      }
	    } catch (Exception e) {
	    }

	    return data;
	  }
	//----------------------------------------------------------------------------------
	public List<EditorHakem> getHakemVerileri() {
	    String sql = "SELECT * FROM hakem;";
	    List<EditorHakem> data = new ArrayList<EditorHakem>();
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
	    	  EditorHakem acyb = new EditorHakem();
	        acyb.setHakemid(rs.getInt("hakem_id"));
	        acyb.setHakemadi(rs.getString("hakem_kul_adi"));
	        data.add(acyb);
	      }
	    } catch (Exception e) {
	    }

	    return data;
	  }
		
}
