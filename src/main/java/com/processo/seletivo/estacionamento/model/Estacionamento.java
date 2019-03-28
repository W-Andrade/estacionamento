package com.processo.seletivo.estacionamento.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Estacionamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date entrada;
	@Temporal(TemporalType.TIMESTAMP)
	private Date saida;
	private Double valorPago;
	private Long tempoPermanencia;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Veiculo veiculo;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Patio patio;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSaida() {
		return saida;
	}
	public void setSaida(Date saida) {
		this.saida = saida;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Patio getPatio() {
		return patio;
	}
	public void setPatio(Patio patio) {
		this.patio = patio;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Long getTempoPermanencia() {
		return tempoPermanencia;
	}
	public void setTempoPermanencia(Long tempoPermanencia) {
		this.tempoPermanencia = tempoPermanencia;
	}
	
}
