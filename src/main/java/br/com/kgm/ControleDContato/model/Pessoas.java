package br.com.kgm.ControleDContato.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_pessoas")
public class Pessoas {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY) //autoincrement
	private Long id;
	@Column(nullable = false) //not null
	private String nome;
	@Column(nullable = true) //not null
	private String endereco;
	@Column(nullable = true) //not null
	private String cep;
	@Column(nullable = true) //not null
	private String cidade;
	@Column(nullable = true) //not null
	private String uf;
	@OneToMany (mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Contato> contato;
	
	public Pessoas() {}

	public Pessoas(Long id, String nome, String endereço, String cep, String cidade, String uf) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereço;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereco;
	}

	public void setEndereço(String endereço) {
		this.endereco = endereço;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
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
		Pessoas other = (Pessoas) obj;
		return Objects.equals(id, other.id);
	}
	
	@Override
	public String toString() {
		return "[id = " + this.id + "," +
				"endereco = " + this.endereco + "," +
				"cep = " + this.cep + "," +
				"cidade = " + this.cidade + "," +
				"uf = " + this.uf + "]" ;
	}

}