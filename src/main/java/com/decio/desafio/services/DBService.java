package com.decio.desafio.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.decio.desafio.domain.Cliente;
import com.decio.desafio.repository.ClienteRepository;


@Service
public class DBService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public void instantiateDataBase() throws ParseException {
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377");
		Cliente cli2 = new Cliente(null, "Joao Silva", "joao@gmail.com", "80445464554");
		
		clienteRepository.saveAll(Arrays.asList(cli1, cli2));

	}
}

