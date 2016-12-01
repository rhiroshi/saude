package com.oficina.saude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.model.Usuario;

public interface Pacientes extends JpaRepository<Paciente, Long> {

	public List<Paciente> findByNomeIgnoreCaseContaining(String nome);
	public Paciente findByUsuario(Usuario usuario);
}
