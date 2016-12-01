package com.oficina.saude.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;

public interface Prontuarios extends JpaRepository<Prontuario, Long>{

	public List<Prontuario> findByStatus(Status status);
	
	@Modifying
	@Transactional
	@Query(value="delete from Prontuario c where c.paciente = ?1")
	public void deleteByPaciente(Paciente paciente);
	
	public Long countByData(Date data);
	
}
