package com.processo.seletivo.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.processo.seletivo.estacionamento.model.Estacionamento;

public interface EstacionamentoDao extends CrudRepository<Estacionamento, Long>{
	
	@Query("select e from Estacionamento e where e.veiculo.placa = ?1 and e.saida is null")
	public Estacionamento findByPlacaAndSaidaIsNull(String placa);
	@Query("select e from Estacionamento e where e.patio.id = ?1 and e.saida is null")
	public List<Estacionamento> findByPatioId(Long patioId);
	
}
