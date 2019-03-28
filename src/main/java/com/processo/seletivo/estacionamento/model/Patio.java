package com.processo.seletivo.estacionamento.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String descricao;
	@Column(nullable = false)
	private Integer quantidadeVagas;
	@Column(nullable = false)
	private Double tavaHora;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getQuantidadeVagas() {
		return quantidadeVagas;
	}
	public void setQuantidadeVagas(Integer quantidadeVagas) {
		this.quantidadeVagas = quantidadeVagas;
	}
	public Double getTavaHora() {
		return tavaHora;
	}
	public void setTavaHora(Double tavaHora) {
		this.tavaHora = tavaHora;
	}
	
}
