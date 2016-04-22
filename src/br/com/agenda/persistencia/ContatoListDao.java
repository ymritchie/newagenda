package br.com.agenda.persistencia;

import java.util.ArrayList;
import java.util.List;

import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;

public class ContatoListDao implements ContatoDao {

    private static ArrayList<Contato> lista = new ArrayList<Contato>();
	
    private static Integer id = 1 ;
    
	
	@Override
	public void delete(Contato contato) {
		lista.remove(contato);
		
	}

	@Override
	public Contato findById(Integer id) {
      Contato tmp = new Contato(id,null);
      return lista.get( lista.indexOf(tmp));
 	}

	@Override
	public void save(Contato contato) {
		contato.setId(id++);
		lista.add(contato);
		
	}

	@Override
	public List<Contato> listContatos() {
		return lista;
	}

	@Override
	public List<Grupo> listGrupos() {
		
		ArrayList<Grupo> lst = new ArrayList<Grupo>();
		
	    lst.add(new Grupo(1,"Amigos"));
	    lst.add(new Grupo(2,"Familia"));
	    lst.add(new Grupo(3,"Trabalho"));
		
		return lst;
	}

	@Override
	public List<Contato> listFavoritos(boolean isFavorito) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> listPorGrupo(Grupo g) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
