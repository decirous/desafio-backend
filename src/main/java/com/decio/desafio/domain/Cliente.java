package com.decio.desafio.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id 
	private String id;
	private String nome;

	private String email;
	private String cpfCNPJ;

	public Cliente() {
		
	}

	public Cliente(String id, String nome, String email, String cpfCNPJ) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfCNPJ = cpfCNPJ;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getCpfCNPJ() {
		return cpfCNPJ;
	}

	public void setCpfCNPJ(String cpfCNPJ) {
		this.cpfCNPJ = cpfCNPJ;
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}

