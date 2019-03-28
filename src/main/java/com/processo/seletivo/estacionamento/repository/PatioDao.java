package com.processo.seletivo.estacionamento.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.processo.seletivo.estacionamento.model.Patio;

public interface PatioDao extends CrudRepository<Patio, Long>{
	public List<Patio> findByDescricaoContaining(String nome);
}
