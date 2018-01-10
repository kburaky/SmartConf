package com.smartconf.editor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "editormakaleGoster")
@SessionScoped
public class EditorMakaleGoster  {

	
	private int    makaleid;
	private String makaleozet;
	private String makalebaslik;
	private String makaleanahtarkelimeler;
	private String makaledurum;
	private String makaleorjinalhali;
	private String makaledosyaadi;
	private String makaleiceriktipi;
	private String makalesonguncelleme;
	private String yazarkuladi;
	private int konferansid;
	private int editorid;
	
	
	public String getYazarkuladi() {
		return yazarkuladi;
	}
	public void setYazarkuladi(String yazarkuladi) {
		this.yazarkuladi = yazarkuladi;
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
	public int getEditorid() {
		return editorid;
	}
	public void setEditorid(int editorid) {
		this.editorid = editorid;
	}
	
	
}
