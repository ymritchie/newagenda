package br.com.agenda.enlaces;

import java.util.Map;
import java.util.TreeMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ThemeSwicher {

    private String meuTema;
    private Map<String, String> themes;

    public ThemeSwicher() {

        themes = new TreeMap<String, String>();  
        themes.put("Afterdark", "afterdark");  
        themes.put("Afternoon", "afternoon"); 
        themes.put("Afterwork", "afterwork"); 
        themes.put("Aristo", "aristo");
        themes.put("Black Tie", "black-tie"); 
        themes.put("Blitzer", "blitzer"); 
        themes.put("Blue Sky", "bluesky"); 
        themes.put("Bootstrap", "bootstrap");
        themes.put("Casa Blanca", "casablanca"); 
        themes.put("Cruze", "cruze"); 
        themes.put("Cupertino", "cupertino"); 
        themes.put("Dark Hive", "dark-hive");
        themes.put("Delta", "delta");
        themes.put("Dot Luv", "dot-luv");
        themes.put("Eggplant", "eggplant");
        themes.put("Excite Bike", "excite-bike");
        themes.put("Flick", "flick");
        themes.put("Glass X", "glass-x");
        themes.put("Home", "home");
        themes.put("Hot Sneaks", "hot-sneaks");
        themes.put("Humanity", "humanity");
        themes.put("Le Frog", "le-frog");
        themes.put("Midnight", "midnight");
        themes.put("Mint Choc", "mint-choc");
        themes.put("Overcast", "overcast");
        themes.put("Pepper Grinder", "pepper-grinder");
        themes.put("Redmond", "redmond");
        themes.put("Rocket", "rocket");
        themes.put("Sam", "sam");
        themes.put("Smoothness", "smoothness");
        themes.put("South Street", "south-street");
        themes.put("Start", "start");
        themes.put("Sunny", "sunny");
        themes.put("Swanky Purse", "swanky-purse");
        themes.put("Trontastic", "trontastic");
        themes.put("UI Darkness", "ui-darkness");
        themes.put("UI Lightness", "ui-lightness");
        themes.put("Vader", "vader");
        

        //aqui voce pode retornar seu tema atual do banco
    }

    public void salvarTema() {  
        //aqui voce pode salvar seu tema no banco
    }

    public String getMeuTema() {
        if(meuTema == null) meuTema = "start";
        return meuTema;
    }

    public void setMeuTema(String meuTema) {
        this.meuTema = meuTema;
    }

    public Map<String, String> getThemes() {
        return themes;
    }

    public void setThemes(Map<String, String> themes) {
        this.themes = themes;
    }
}
