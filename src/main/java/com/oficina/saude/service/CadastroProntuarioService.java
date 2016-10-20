package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Prontuario;
import com.oficina.saude.repository.Prontuarios;

@Service
public class CadastroProntuarioService {

	@Autowired
	Prontuarios prontuarios;
	
	public void salvar(Prontuario prontuario){
		this.prontuarios.save(prontuario);
	}
	
}
