package com.oficina.saude.repository.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.model.Status;

public class ConsultasImpl implements ConsultasQueries{

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Consulta> consultasRealizadas() {
		return manager
				.createQuery("from Consulta where prontuario.status = :status", Consulta.class)
				.setParameter("status", Status.ATENDIDO)
				.getResultList();
	}
	
}
