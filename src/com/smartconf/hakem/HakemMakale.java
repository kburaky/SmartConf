package com.smartconf.hakem;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "hakemMakale")
@SessionScoped
public class HakemMakale {

	
	private int hakemmakaleid;
	
	
	
	private int makaleid;
	private String makaleozet;
	private String makalebaslik;
	private String makaleanahtarkelimeler;
	private String makaleorjinalhali;
	private String makaleiceriktipi;
	
	

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
	
	public String getMakaleorjinalhali() {
		return makaleorjinalhali;
	}
	public void setMakaleorjinalhali(String makaleorjinalhali) {
		this.makaleorjinalhali = makaleorjinalhali;
	}
	
	public String getMakaleiceriktipi() {
		return makaleiceriktipi;
	}
	public void setMakaleiceriktipi(String makaleiceriktipi) {
		this.makaleiceriktipi = makaleiceriktipi;
	}
	public int getHakemmakaleid() {
		return hakemmakaleid;
	}
	public void setHakemmakaleid(int hakemmakaleid) {
		this.hakemmakaleid = hakemmakaleid;
	}
	public int getMakaleid() {
		return makaleid;
	}
	public void setMakaleid(int makaleid) {
		this.makaleid = makaleid;
	}
	
		
}
