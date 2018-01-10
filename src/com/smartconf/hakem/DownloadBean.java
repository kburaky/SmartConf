package com.smartconf.hakem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.URL;









import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

@ManagedBean(name = "downloadBean")
@SessionScoped

public class DownloadBean  {
	 
	
	private static final int DEFAULT_BUFFER_SIZE = 10240;  
	   private String filePath = "C:\\DB\\";
	   
       public void downLoad() throws IOException {  
    	   HakemDosyaBean nesne = new HakemDosyaBean();	
           String dene = nesne.getDosyaList().get(0).getDosyaadi(); 
    	   
    	   
    	     FacesContext context = FacesContext.getCurrentInstance();  
	            HttpServletResponse response = (HttpServletResponse) context  
	                      .getExternalContext().getResponse();  
	            File file = new File(filePath+dene);  
	            if (!file.exists()) {  
	                 response.sendError(HttpServletResponse.SC_NOT_FOUND);  
	                 return;  
            }  
	            response.reset();  
	            response.setBufferSize(DEFAULT_BUFFER_SIZE);  
	            response.setContentType("application/octet-stream");  
	            response.setHeader("Content-Length", String.valueOf(file.length()));  
	            response.setHeader("Content-Disposition", "attachment;filename=\""  
	                      + file.getName() + "\"");  
	            BufferedInputStream input = null;  
	            BufferedOutputStream output = null;  
	            try {  
	                 input = new BufferedInputStream(new FileInputStream(file),  
	                           DEFAULT_BUFFER_SIZE);  
	                 output = new BufferedOutputStream(response.getOutputStream(),  
	                           DEFAULT_BUFFER_SIZE);  
	                 byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];  
	                 int length;  
	                while ((length = input.read(buffer)) > 0) {  
	                      output.write(buffer, 0, length);  
	                 }  
	            } finally {  
	                 input.close();  
	                 output.close();  
            }  
	           context.responseComplete();  
	       }  
	
}

