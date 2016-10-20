package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Farmaceutico;
import com.oficina.saude.repository.Farmaceuticos;

@Service
public class CadastroFarmaceuticoService {

	@Autowired
	private Farmaceuticos farmaceuticos;
	
	public void salvar(Farmaceutico farmaceutico){
		this.farmaceuticos.save(farmaceutico);
	}
	
}
