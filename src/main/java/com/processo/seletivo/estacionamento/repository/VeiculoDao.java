package com.processo.seletivo.estacionamento.repository;

import org.springframework.data.repository.CrudRepository;

import com.processo.seletivo.estacionamento.model.Veiculo;

public interface VeiculoDao extends CrudRepository<Veiculo, Long>{
	public Veiculo findByPlaca(String placa);
}
