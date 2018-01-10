package com.smartconf.hakem;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.smartconf.yazar.Util;
 
@ManagedBean(name = "loginBeanHakem")
@SessionScoped
 
public class LoginBeanHakem implements Serializable {
 

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
    	
    	
        boolean result = UserDAOHakem.login(uname, password);
        
        if (result) {
        	
        	HttpSession session = Utilm.getSession();
            session.setAttribute("username", uname);
        	
        	
       
            return "homehakem";
            
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