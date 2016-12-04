package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.PedidoMedicamento;
import com.oficina.saude.repository.PedidosMedicamentos;

@Service
public class CadastroPedidosMedicamentosService {

	@Autowired
	private PedidosMedicamentos pedidosMedicamentos;
	
	public PedidoMedicamento salvar(PedidoMedicamento pdmd){
		return pedidosMedicamentos.saveAndFlush(pdmd);
	}
}
