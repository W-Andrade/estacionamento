package com.processo.seletivo.estacionamento.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.processo.seletivo.estacionamento.model.Cliente;
import com.processo.seletivo.estacionamento.repository.ClienteDao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteRest {

	@Autowired
	private ClienteDao clienteDao;
	
	@ApiOperation(
			value="salvar", 
			notes="Essa operação salva um novo registro com as informações de cliente.")
	@RequestMapping(method = RequestMethod.POST)
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteDao.save(cliente);
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação retorna todos os cliente cadastrados.")
	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> listar(){
		return Lists.newArrayList(clienteDao.findAll());
	}
	
	@ApiOperation(
			value="consultar", 
			notes="Essa operação consulta cliente por cpf ou por nome.")
	@RequestMapping(value = "/consultar/{parametro}", method = RequestMethod.GET)
	public Cliente consultar(@PathVariable("parametro") String parametro) {
		if(parametro.matches("[a-zA-Z_].*")) {
			return clienteDao.findByNomeContaining(parametro);
		}
		return clienteDao.findByCpf(parametro);
	}
}
