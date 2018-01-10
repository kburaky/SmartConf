package com.smartconf.yazar;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
 
@ManagedBean(name = "loginBeanYazar")
@SessionScoped
 
public class LoginBeanYazar implements Serializable {
 

	private static final long serialVersionUID = 1L;
	
    private String uname;
    private String password;
 
     
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
    public String getUname() {
        return uname;
    }
 
    public void setUname(String uname) {
        this.uname = uname;
    }
 

    public String loginProject() {
    	
    	
        boolean result = UserDAOYazar.login(uname, password);
        
        if (result) {
        	
        	//Oturum Acma Ýþlemleri
        	HttpSession session = Util.getSession();
            session.setAttribute("username", uname);
        	
       
            return "homeyazar";
            
        } else {
            
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Geçersiz Giriþ!",
                    "Lütfen Tekrar Deneyin!"));
            return "login";
        }
    }
    
   
}