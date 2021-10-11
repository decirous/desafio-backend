package com.decio.desafio.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.decio.desafio.domain.Cliente;


@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {

	@Transactional(readOnly = true)
	Cliente findByEmail(String email);
}