package br.com.agenda.nucleo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@NamedQueries({@NamedQuery(name="Contato.listAll", query="from Contato")})
@Table(name="tb_contato")
public class Contato {

	private Integer id = null;
	
	private String nome, ddd, telefone;
	
	private String email;
	
	private Integer discagemRapida;
	
	private boolean favorito;
	
	private Date aniversario;
	
	private Grupo grupo;
	
	private Endereco endereco;
	
	public Contato() { 
	  this(0,null);	
	}

	public Contato(Integer id, String nome) {
		
		this.id = id;
		this.nome = nome;
		
		grupo = new Grupo(); 
		endereco = new Endereco();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="contato_seq_gen")
	@SequenceGenerator(name = "contato_seq_gen", sequenceName = "contato_id_seq", allocationSize=1)
	@Column(name="sq_contato")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
   
	@Transient
	public Integer getDiscagemRapida() {
		return discagemRapida;
	}
	
	
	public void setDiscagemRapida(Integer discagemRapida) {
		this.discagemRapida = discagemRapida;
	}

	
	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
	
	
	@ManyToOne
	@JoinColumn(name="sq_grupo")
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sq_endereco")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", discagemRapida="
				+ discagemRapida + ", favorito=" + favorito + ", aniversario="
				+ aniversario + ", grupo=" + grupo + ", endereco=" + endereco
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

