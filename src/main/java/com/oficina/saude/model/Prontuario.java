package com.oficina.saude.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Prontuario {

	@Id
	private Integer id;
	@NotNull(message="Pressão é obrigatório")
	private String pressao;
	@NotNull(message="Data é obrigatório")
	private Date data;
	private String prescricao;
	@NotNull(message="Altura é obrigatório")
	private float altura;
	@NotNull(message="Peso é obrigatório")
	private float peso;
	
}
