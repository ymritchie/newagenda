package br.com.agenda.persistencia;

import java.util.List;

import br.com.agenda.nucleo.Grupo;

public interface GrupoDao {
	
	public void save(Grupo grupo);
	
	public void delete(Grupo grupo);
	
	public Grupo findById(Integer id);
	
	public List<Grupo> listGrupos();

}
