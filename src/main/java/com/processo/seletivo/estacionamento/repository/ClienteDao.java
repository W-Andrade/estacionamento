package com.processo.seletivo.estacionamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.processo.seletivo.estacionamento.model.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Long>{
	public Cliente findByCpf(String cpf);
	public Cliente findByNomeContaining(String nome);
}
