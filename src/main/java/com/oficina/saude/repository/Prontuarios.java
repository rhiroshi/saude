package com.oficina.saude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;

public interface Prontuarios extends JpaRepository<Prontuario, Long>{

	public List<Prontuario> findByStatus(Status status);
}
