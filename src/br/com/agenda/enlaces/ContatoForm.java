package br.com.agenda.enlaces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import br.com.agenda.app.Facade;
import br.com.agenda.app.FacadeImp;
import br.com.agenda.nucleo.Contato;
import br.com.agenda.nucleo.Grupo;


 

@ManagedBean
@SessionScoped
public class ContatoForm {
	private DataModel<Contato> dataModel;
	private Contato pessoa;
	private Facade facade;
	private boolean isSaveState = true;
	
	
	public ContatoForm (){
		pessoa = new Contato();
		facade = new FacadeImp();
		dataModel =  new ListDataModel<Contato>(facade.findAll());
	}

	public Contato getPessoa() {
		return pessoa;
	}

	public void setPessoa(Contato pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isSaveState() {
		return isSaveState;
	}

	public void setSaveState(boolean isSaveState) {
		this.isSaveState = isSaveState;
	}

	public List<Grupo> getGrupos (){
		return facade.findAllGrupo();
	}
	
	public void save (){
		System.out.println(pessoa.toString());
		facade.salvar(pessoa);
		pessoa = new Contato();
		FacesUtil.addMessage ("Operação realizada com sucesso.");
	}

	public DataModel<Contato> getDataModel() {
		return dataModel;
	}

	public void setDataModel(DataModel<Contato> dataModel) {
		this.dataModel = dataModel;
	}

	public void voltar(){
		if (isSaveState()) {
			dataModel = new ListDataModel<Contato>(facade.findAll());
		}
		isSaveState = !isSaveState;
	}
	
	public void editar(){
		pessoa = dataModel.getRowData();
		voltar();
		
	}
	
	public void deletar(){
		pessoa = dataModel.getRowData();
		facade.deletar(pessoa);
		pessoa = new Contato();
		dataModel = new ListDataModel<Contato>(facade.findAll());
		FacesUtil.addMessage("Operação realizada com sucesso");
	}
			
}