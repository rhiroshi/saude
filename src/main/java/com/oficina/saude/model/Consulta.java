package com.oficina.saude.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Consulta {

	@Id
	private int id;
	@NotNull(message="Data é obrigatório")
	private Date data;
	@NotNull(message="Status é obrigatório")
	private String status;
	
}
