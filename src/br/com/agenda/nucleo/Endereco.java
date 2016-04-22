package br.com.agenda.nucleo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tb_endereco")
public class Endereco {
	
	private Integer id;
	
	private String rua;

	public Endereco() {
		this(null,null);
		
	}
	
	public Endereco(Integer id, String rua) {
		super();
		this.id = id;
		this.rua = rua;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="endereco_seq_gen")
	@SequenceGenerator(name = "endereco_seq_gen", sequenceName = "endereco_id_seq", allocationSize=1)
	@Column(name="sq_endereco")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="tx_rua")
	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return rua;
	}

}
