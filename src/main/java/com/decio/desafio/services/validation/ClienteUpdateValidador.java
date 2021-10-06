package com.decio.desafio.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.decio.desafio.domain.Cliente;
import com.decio.desafio.dto.ClienteDTO;
import com.decio.desafio.repository.ClienteRepository;
import com.decio.desafio.resourses.exception.FieldMessage;


public class ClienteUpdateValidador implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ClienteRepository repo;

	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO dto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> mapa = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

		Integer urlId = Integer.parseInt(mapa.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();

		Cliente aux = repo.findByEmail(dto.getEmail());
		System.out.println("--------------> " + aux.getId().equals(urlId));
		if (aux != null && !aux.getId().equals(urlId)) {
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
