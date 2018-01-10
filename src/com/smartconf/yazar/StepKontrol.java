package com.smartconf.yazar;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;


@ManagedBean(name = "step")
@SessionScoped

public class StepKontrol {
	
	private int activeIndex;
	
	private RequestContext context;
	
	public StepKontrol() {
		
		this.activeIndex = 0;
		
	}

	
	public int getActiveIndex() {
		return activeIndex;
	}

	public void setActiveIndex(int activeIndex) {
		this.activeIndex = activeIndex;
	}
	
	public void ileri(){
        if(getActiveIndex()<3){
            this.activeIndex++;
            
            step();
        }
    }
    public void geri(){
        if(getActiveIndex()>0){
            this.activeIndex--;
            step();
        }
    }
    
    
    public void step(){
        
    	if(getActiveIndex() == 0){
            context=RequestContext.getCurrentInstance();
            context.execute("$('#div1').show();$('#div2').hide();$('#ileri').show();$('#geri').hide();");
            context.update("step");
        }
        if(getActiveIndex() == 1){
            context=RequestContext.getCurrentInstance();
            context.execute("$('#div1').hide();$('#div2').show();$('#div3').hide();$('#div4').hide();$('#ileri').show();$('#geri').show();");
            context.update("step");
        }
        if(getActiveIndex() == 2){
            context=RequestContext.getCurrentInstance();
            context.execute("$('#div1').hide();$('#div2').hide();$('#div3').show();$('#div4').hide();$('#ileri').show();$('#geri').show();");
            context.update("step");
        }
        if(getActiveIndex() == 3){
            context=RequestContext.getCurrentInstance();
            context.execute("$('#div1').hide();$('#div2').hide();$('#div3').hide();$('#div4').show();$('#ileri').hide();$('#geri').show();");
            context.update("step");
        }
        
    }
	
	
}
