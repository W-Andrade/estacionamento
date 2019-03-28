package com.processo.seletivo.estacionamento.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;
import com.processo.seletivo.estacionamento.model.Patio;
import com.processo.seletivo.estacionamento.repository.PatioDao;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/patio")
public class PatioRest {

	@Autowired
	private PatioDao patioDao;
	
	@ApiOperation(
			value="salvar", 
			notes="Essa operação salva um novo registro com as informações de patio.")
	@RequestMapping(method = RequestMethod.POST)
	public Patio salvar(@RequestBody Patio patio) {
		return patioDao.save(patio);
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação retorna todos os patio cadastrados.")
	@RequestMapping(method = RequestMethod.GET)
	public List<Patio> listar(){
		return Lists.newArrayList(patioDao.findAll());
	}
	
	@ApiOperation(
			value="Lista", 
			notes="Essa operação consulta cliente por nome.")
	@RequestMapping(value = "/consultar/{nome}", method = RequestMethod.GET)
	public List<Patio> consulta(@PathVariable String nome) {
		return patioDao.findByDescricaoContaining(nome);
	}
}
