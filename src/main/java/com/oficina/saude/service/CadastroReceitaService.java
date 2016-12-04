package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Receita;
import com.oficina.saude.repository.Receitas;

@Service
public class CadastroReceitaService {

	@Autowired
	private Receitas receitas;
	
	
	public void salvar(Receita receita){
		this.receitas.save(receita);
	}
	
}
