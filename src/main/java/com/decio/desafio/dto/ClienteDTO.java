package com.decio.desafio.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.decio.desafio.domain.Cliente;
import com.decio.desafio.services.validation.ClienteUpdate;


@ClienteUpdate
public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Length(min = 5, max = 120, message="O tamanho deve ser entre 5 e 120 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento Obrigatório!")
	@Email(message="Email inválido!")
	private String email;

	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
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
	
	
}
