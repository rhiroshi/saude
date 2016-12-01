package com.oficina.saude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.repository.helper.ConsultasQueries;


public interface Consultas extends JpaRepository<Consulta, Long>, ConsultasQueries {

	public List<Consulta> consultasRealizadas();
	
}
