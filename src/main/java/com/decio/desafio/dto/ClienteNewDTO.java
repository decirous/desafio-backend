package com.decio.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.decio.desafio.services.validation.ClienteInsert;


@ClienteInsert
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento Obrigatório!")
	@Length(min = 5, max = 120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;

	@NotEmpty(message="Preenchimento Obrigatório!")
	@Email(message="Email inválido!")
	private String email;

	@NotEmpty(message="Preenchimento Obrigatório!")
	private String cpfCNPJ;
	
	public ClienteNewDTO() {
		
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

	
}
