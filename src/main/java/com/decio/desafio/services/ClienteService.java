package com.decio.desafio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.decio.desafio.domain.Cliente;
import com.decio.desafio.repository.ClienteRepository;
import com.decio.desafio.services.exception.DataIntegrityException;
import com.decio.desafio.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		 Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}

	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionadas.");
		}
	}

	public List<Cliente> findAll() {
		return repo.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pr = PageRequest.of(page, linesPerPage, Direction.fromString(direction), orderBy);
		return repo.findAll(pr);
	} 

//	public Cliente fromDTO(@Valid ClienteDTO objDto) {
//		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
//	}

	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

//	public Cliente fromDTO(@Valid ClienteNewDTO objDto) {
//
//		Cliente cli = new Cliente(null, objDto.getNome(), objDto.getEmail(), objDto.getCpfCNPJ(), TipoCliente.toEnum(objDto.getTipo()));
//		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
//		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getComplemento(), objDto.getBairro(), objDto.getCep(), cli, cid);
//		cli.getEnderecos().add(end);
//		cli.getTelefones().add(objDto.getTelefone1());
//		if (objDto.getTelefone2() != null) {
//			cli.getTelefones().add(objDto.getTelefone2());
//		}
//		if (objDto.getTelefone3() != null) {
//			cli.getTelefones().add(objDto.getTelefone3());
//		}
//		
//		return cli;
//	}
}

