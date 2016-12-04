package com.oficina.saude.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Receita {

	@Id
	private Long codigo;
	
	@OneToOne
	@JoinColumn(name="consulta")
	private Consulta consulta;
	
	@OneToMany(mappedBy="receita")
	private List<PedidoMedicamento> pedidos;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public List<PedidoMedicamento> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidoMedicamento> pedidos) {
		this.pedidos = pedidos;
	}
	
	
}
