package com.oficina.saude.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="receita")
public class Receita implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	
	@JsonManagedReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="consulta")
	private Consulta consulta;

	@JsonBackReference
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
