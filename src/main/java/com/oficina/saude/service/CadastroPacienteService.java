package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.repository.Pacientes;

@Service
public class CadastroPacienteService {

	@Autowired
	Pacientes pacientes;
	
	public void salvar(Paciente paciente){
		this.pacientes.save(paciente);
	}
}
