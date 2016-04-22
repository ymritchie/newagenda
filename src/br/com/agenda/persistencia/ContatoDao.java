package br.com.agenda.persistencia;

import java.util.List;

import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;

public interface ContatoDao {

	public void save(Contato contato);
	
	public void delete(Contato contato);
	
	public Contato findById(Integer id);
	
	public List<Contato> listContatos(); 
	
	public List<Grupo> listGrupos();
	
	public List<Contato> listFavoritos(boolean isFavorito);
	
	public List<Contato> listPorGrupo(Grupo g);
}