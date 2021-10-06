package com.decio.desafio.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.decio.desafio.domain.Cliente;
import com.decio.desafio.dto.ClienteNewDTO;
import com.decio.desafio.repository.ClienteRepository;
import com.decio.desafio.resourses.exception.FieldMessage;


public class ClienteInsertValidador implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO dto, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		Cliente aux = repo.findByEmail(dto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email existente."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}

