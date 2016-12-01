package com.oficina.saude.repository.helper;

import java.util.List;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.model.Paciente;;

public interface ConsultasQueries {

	public List<Consulta> consultasRealizadas(Paciente paciente);
	
}
