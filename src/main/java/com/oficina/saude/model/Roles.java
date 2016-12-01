package com.oficina.saude.model;

public enum Roles {
	
	FARMACO("Farmaceutico"),
	MEDICO("Médico"),
	PACIENTE("Paciente"),
	ADMIN("Admin");
	
	private String descricao;
	
	Roles(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
