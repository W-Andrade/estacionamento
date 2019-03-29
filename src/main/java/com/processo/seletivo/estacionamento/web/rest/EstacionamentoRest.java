package com.processo.seletivo.estacionamento.web.rest;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.processo.seletivo.estacionamento.model.Estacionamento;
import com.processo.seletivo.estacionamento.repository.EstacionamentoDao;
import com.processo.seletivo.estacionamento.repository.PatioDao;
import com.processo.seletivo.estacionamento.repository.VeiculoDao;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/estacionamento")
public class EstacionamentoRest {

	@Autowired
	private EstacionamentoDao estacionamentoDao;
	
	@Autowired
	private PatioDao patioDao;
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	@ApiOperation(
			value="salvar", 
			notes="Essa operação salva uma nova entra ou saida do estacionamento."
					+ "\n\n\t É obrigadora passar um objeto contento ao menos "
					+ "\n\t{"
					+ "\n\t\t\"placa\":\"ogq-1563\","
					+ "\n\t\t\"patioId\":1"
					+ "\n\t}")
	@RequestMapping(method = RequestMethod.POST)
	public Estacionamento salvar(@RequestBody Map<String, Object> parametros) {
		String placa   = (String)parametros.get("placa");
		Long   patioId = new Long(parametros.get("patioId").toString());

		Estacionamento estacionamento = estacionamentoDao.findByPlacaAndSaidaIsNull(placa);
		if(estacionamento == null) {
			estacionamento = new Estacionamento();
			estacionamento.setEntrada(new Date());
			estacionamento.setVeiculo(veiculoDao.findByPlaca(placa));
			estacionamento.setPatio(patioDao.findById(patioId).get());
		}else {
			estacionamento.setSaida(new Date());
			double entrada = estacionamento.getEntrada().getTime() / 3600000.0;
			double saida   = estacionamento.getSaida().getTime() / 3600000.0;
			double horas = (saida - entrada);
			horas = Math.ceil(horas);
			estacionamento.setTempoPermanencia((long)horas);
			estacionamento.setValorPago(horas * estacionamento.getPatio().getTavaHora());
		}
		estacionamentoDao.save(estacionamento);
		return estacionamento;
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação retorna todos as vagas ocupadas.")
	@RequestMapping(value = "/{patioId}", method = RequestMethod.GET)
	public List<Estacionamento> listarVagas(@PathVariable Long patioId){
		return estacionamentoDao.findByPatioId(patioId);
	}
}
