package com.smartconf.editor;

import com.smartconf.editor.UserDAO;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean(name = "loginBeanEditor")
@SessionScoped
 
public class LoginBean implements Serializable {
 

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
    	    	
        boolean result = UserDAO.login(uname, password);
        
        if (result) {
        	
            return "homeeditor";       
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