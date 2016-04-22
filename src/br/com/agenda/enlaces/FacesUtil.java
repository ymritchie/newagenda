package br.com.agenda.enlaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	
	public static void addMessage(String message){
		FacesMessage fm = new FacesMessage(message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void addWarn(String message){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN,message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void addErro(String message){
		FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR,message, message);
		FacesContext.getCurrentInstance().addMessage(null, fm);
	}
	
	public static void setSession(String atribute, Object value){
		
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(atribute, value);
	}
	
	public static Object getSession(String atribute){
		
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(atribute);
	
	}
	
	public static void setRequest(String atribute, Object value){
			
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(atribute, value);
	}
	
	public static Object getRequest(String atribute){
		
		return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(atribute);
	
	}
}
