package com.processo.seletivo.estacionamento.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.processo.seletivo.estacionamento.model.Veiculo;
import com.processo.seletivo.estacionamento.repository.VeiculoDao;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/veiculo")
public class VeiculoRest {

	@Autowired
	private VeiculoDao veiculoDao;
	
	@ApiOperation(
			value="salvar", 
			notes="Essa operação salva um novo registro com as informações de veiculo.")
	@RequestMapping(method = RequestMethod.POST)
	public Veiculo salvar(@RequestBody Veiculo veiculo) {
		return veiculoDao.save(veiculo);
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação retorna todos os veiculo cadastrados.")
	@RequestMapping(method = RequestMethod.GET)
	public List<Veiculo> listar(){
		return Lists.newArrayList(veiculoDao.findAll());
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação consulta veiculo pela placa.")
	@RequestMapping(value = "/consultar/{placa}", method = RequestMethod.GET)
	public Veiculo consultar(@PathVariable("placa") String placa){
		return veiculoDao.findByPlaca(placa);
	}
}
