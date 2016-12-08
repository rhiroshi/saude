package com.oficina.saude.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oficina.saude.model.PedidoMedicamento;
import com.oficina.saude.model.Receita;
import com.oficina.saude.repository.Receitas;

@RestController
public class ReceitaController {

	
	@Autowired
	private Receitas receitas;
	
	@RequestMapping(value="/receita/pesquisa", method=RequestMethod.GET, consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<PedidoMedicamento> pesquisaUm(@RequestParam Long codigo){
		Receita ret1 = receitas.findOne(codigo);
		return ret1.getPedidos();
	}
	
}
