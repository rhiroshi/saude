package com.oficina.saude.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.repository.Pacientes;
import com.oficina.saude.repository.Prontuarios;

@Service
public class CadastroPacienteService {

	@Autowired
	private Pacientes pacientes;
	
	@Autowired
	private Prontuarios prontuarios;
	
	public void salvar(Paciente paciente){
		this.pacientes.save(paciente);
	}
	
	public List<Paciente> pesquisar(String nome) {
		List<Paciente> listaPacientes = new ArrayList<>();
		listaPacientes = pacientes.findByNomeIgnoreCaseContaining(nome);
		return listaPacientes;
	}
	
	public void excluir(Long cpf){
		prontuarios.deleteByPaciente(pacientes.findOne(cpf));
		this.pacientes.delete(cpf);
	}
}
