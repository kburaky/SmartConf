package com.smartconf.editor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editorDosya")
@SessionScoped

public class EditorDosya {

	private int dosyaid;
	private String yazarkullaniciadi;
	private String dosyaadi;
	private String tarih;
	private String durum;
	
	
	public String getYazarkullaniciadi() {
		return yazarkullaniciadi;
	}
	public void setYazarkullaniciadi(String yazarkullaniciadi) {
		this.yazarkullaniciadi = yazarkullaniciadi;
	}
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
	public String getDosyaadi() {
		return dosyaadi;
	}
	public void setDosyaadi(String dosyaadi) {
		this.dosyaadi = dosyaadi;
	}
		
}
