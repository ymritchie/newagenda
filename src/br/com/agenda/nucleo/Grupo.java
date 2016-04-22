package br.com.agenda.nucleo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_grupo")
public class Grupo {

	private Integer id;
	
	private String nome;

	public Grupo() {
		this(null,null);
	}
	
	public Grupo(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	public Grupo(String nome) {
		super();
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grupo_seq_gen")
	@SequenceGenerator(name = "grupo_seq_gen", sequenceName = "grupo_id_seq", allocationSize=1)
	@Column(name="sq_grupo")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="tx_nome")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Grupo [id= " + id + ", Nome="+ nome+ "]";
	}
	
	
	
}
