package com.smartconf.yazar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
  
@ManagedBean(name="fileUploadController")
@SessionScoped
public class FileUploadController {
   
	private String destination="C:\\DB\\";
   
  
	public void upload(FileUploadEvent event) {  
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        // Do what you want with the file        
        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }  
	
    public void copyFile(String fileName, InputStream in) {
           try {
                     
                // write the inputStream to a FileOutputStream
                OutputStream out = new FileOutputStream(new File(destination + "SC-"+fileName));
              
                int read = 0;
                byte[] bytes = new byte[1024];
              
                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
              
                in.close();
                out.flush();
                out.close();
              
                System.out.println("Yeni Yazi Eklendi.");
                } catch (IOException e) {
                System.out.println(e.getMessage());
                }
           
           
         //burasý dosyaadýnýn kaydedilecegi yer
         PreparedStatement ps = null;
   		 Connection con = null;
   		 

   		 Util m =new Util();
   		
   		 
   			try
       		{
   				
   				Date simdikiZaman = new Date();
   				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
   		        //System.out.println(df.format(simdikiZaman));
   				
   				
   				
   				
       			Class.forName("com.mysql.jdbc.Driver");
       			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartconf", "root", "root");
       			String sql = "INSERT INTO DOSYA (yazar_kullanici_adi,dosya_adi,tarih,durum) VALUES(?,?,?,?)";
       			ps= con.prepareStatement(sql);
       			

       			ps.setString(1, m.getUserName());
       			ps.setString(2, "SC-"+fileName);	
       			ps.setString(3, df.format(simdikiZaman));
       			ps.setString(4, "inceleniyor");

       			
       			int i = ps.executeUpdate();
       			if(i >0){  		 			
   	    			System.out.println("KAYIT BASARILI");
   	    			
       			}
   				
       			
       		}
       		catch(Exception e)
       		{
       			e.printStackTrace();
       			System.out.println("HATA: "+e);
       			
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
