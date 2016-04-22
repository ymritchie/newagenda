package br.com.agenda.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.agenda.enlaces.LoginUserForm;

@FacesValidator(value="loginUserValidator")
public class LoginUserValidator implements Validator{

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object valor)
			throws ValidatorException {
		
		LoginUserForm luv = (LoginUserForm) valor;
		
		
		System.out.println(luv.getUser().getNomeUser());
		if (!luv.getUser().getNomeUser().toLowerCase().equals("yanisley") || 
				!luv.getUser().getSenha().equals("mora")) {
				
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou Senha Invalido", null);
			throw new ValidatorException(fm);
		}
		
	}

}
