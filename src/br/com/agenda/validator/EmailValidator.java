package br.com.agenda.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import java.util.regex.*; 

@FacesValidator(value="emailValidator")
public class EmailValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent valor, Object mail)
			throws ValidatorException {
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(valor.getClientId().valueOf(mail)); 
		
		if (!m.find()){
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail inválido", null);
			throw new ValidatorException(fm);
		}
		
	}

	
	
}
