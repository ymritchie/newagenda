package br.com.agenda.app;

import java.util.List;

import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;
import br.com.agenda.persistencia.ContatoDao;
import br.com.agenda.persistencia.ContatoMySqlDao;
import br.com.agenda.persistencia.GrupoDao;
import br.com.agenda.persistencia.GrupoMySqlDao;

public class FacadeImp implements Facade {
		
	private ContatoDao contatoDao;
	private GrupoDao grupoDdao;
	
	public FacadeImp (){
		
		contatoDao =  new ContatoMySqlDao();
		grupoDdao =  new GrupoMySqlDao();
	}
	@Override
	public void salvar(Contato contato) {
		contatoDao.save(contato);
	}

	@Override
	public void deletar(Contato contato) {
		contatoDao.delete(contato);
		
	}

	@Override
	public Contato findById(Integer id) {
		return contatoDao.findById(id);
	}

	@Override
	public List<Contato> findAll() {
		return contatoDao.listContatos();
	}

	@Override
	public List<Contato> findFavoritos(boolean isFavorito) {
		return contatoDao.listFavoritos(isFavorito);
	}

	@Override
	public List<Contato> findByGrupo(Grupo g) {
		return contatoDao.listPorGrupo(g);
	}
	@Override
	public List<Grupo> findAllGrupo() {
		// TODO Auto-generated method stub
		return grupoDdao.listGrupos();
	}
	
	

}
