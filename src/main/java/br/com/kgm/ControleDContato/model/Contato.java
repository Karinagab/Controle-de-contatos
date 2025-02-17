package br.com.kgm.ControleDContato.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cadastro")
	public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Integer contato;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoas pessoa;
	
	public Contato() {}
	public Contato(Long id, Integer contato, Pessoas pessoa) {
		this.id = id;
		this.contato = contato;
		this.pessoa = pessoa;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getContato() {
		return contato;
	}
	public void setContato(Integer contato) {
		this.contato = contato;
	}
	
	
	public Pessoas getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoas pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
	public String toString() {
		return "[id = " + this.id + "," +
				"contato = " + this.contato + "]";
	}


}