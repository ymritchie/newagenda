package br.com.agenda.enlaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.agenda.nucleo.LoginUser;

@ManagedBean
@SessionScoped
public class LoginUserForm {

	private LoginUser user;
	
	public LoginUserForm (){
		user = new LoginUser();
	}

	public LoginUser getUser() {
		return user;
	}

	public void setUser(LoginUser user) {
		this.user = user;
	}
	
	public String logonUser() {
		String result =  null;
		try {
			if (!getUser().getNomeUser().toLowerCase().equals("yanisley") || 
					getUser().getNomeUser().equals(null) || getUser().getSenha().equals(null) || 
					!getUser().getSenha().equals("mora")){
				throw new Exception();
			} else {
				result = "logar";
			}
			
		} catch (Exception ex){
			FacesUtil.addErro("Usuário ou senha Inválido");
		}
		
		return result;
	}
	
	
}
