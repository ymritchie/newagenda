package br.com.agenda.enlaces;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class International {

	private String lang = null;
	private String country = null;
	
	
	
	
	public String mudarIdioma() {
		if (!"".equals(country)) {
			this.mudarLocalidade(new Locale(lang, country));
		} else {
			this.mudarLocalidade(new Locale(lang));
		}
		return null;
	}

	private void mudarLocalidade(Locale locale) {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	
	/** Metodos get e set */

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}