package com.smartconf.hakem;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "hakem")
@SessionScoped
public class Hakem {
	
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
	private String hakemuzmanlikalani;
	
	
	
	
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
	public String getHakemuzmanlikalani() {
		return hakemuzmanlikalani;
	}
	public void setHakemuzmanlikalani(String hakemuzmanlikalani) {
		this.hakemuzmanlikalani = hakemuzmanlikalani;
	}
	
}
