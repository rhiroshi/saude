package com.oficina.saude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Paciente;

public interface Pacientes extends JpaRepository<Paciente, Long> {

	public List<Paciente> findByNomeContaining(String nome);
	
}
