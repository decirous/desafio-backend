package com.decio.desafio.resourses.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;

	private List<FieldMessage> lista = new ArrayList<>();

	public ValidationError(Integer status, String message, Long timestamp) {
		super(status, message, timestamp);
	}

	public List<FieldMessage> getErrors() {
		return lista;
	}

	public void addError(String fieldName, String message) {
		lista.add(new FieldMessage(fieldName, message));
	}


}
