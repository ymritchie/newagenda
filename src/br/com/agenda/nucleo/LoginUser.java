package br.com.agenda.nucleo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_users")
public class LoginUser {
	
	private Integer id;
	private String nomeUser;
	private String senha;
	
	public LoginUser(){
		
		this(null,null);
	}
	
	public LoginUser(String nomeUser, String senha) {
		this.nomeUser = nomeUser;
		this.senha = senha;
	}
	
	public String getNomeUser() {
		return nomeUser;
	}
	
	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq_gen")
	@SequenceGenerator(name = "user_seq_gen", sequenceName = "user_id_seq", allocationSize=1)
	@Column(name="sq_user")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
