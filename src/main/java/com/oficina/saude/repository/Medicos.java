package com.oficina.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Medico;

public interface Medicos extends JpaRepository<Medico,Long>{

	public Medico findOneByUsuarioEmail(String email);
	
}
