package com.oficina.saude.model;

public enum Status {

	ATENDIDO("Atendido"),
	AGUARDANDO("Aguardando");
	
	private String descricao;
	
	Status(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}
