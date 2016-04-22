package br.com.agenda.app;

import java.util.List;

import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;

public interface Facade {
	
	public void salvar (Contato contato);
	
	public void deletar (Contato contato);
	
	public Contato findById(Integer id);
	
	public List<Contato> findAll(); 
	
	public List<Grupo> findAllGrupo();
	
	public List<Contato> findFavoritos(boolean isFavorito);
	
	public List<Contato> findByGrupo(Grupo g);

}
