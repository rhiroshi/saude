package com.oficina.saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.repository.Consultas;
import com.oficina.saude.service.CadastroReceitaService;

@RestController
public class ReceitaController {

	@Autowired
	private CadastroReceitaService receitaService;
	
	@Autowired
	private Consultas receitas;
	
	@RequestMapping(value="/receita/pesquisa", method=RequestMethod.GET, consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody Consulta pesquisaUm(@RequestParam Long codigo){
		Consulta ret = receitas.findOne(codigo);
		return ret;
	}
	
}
