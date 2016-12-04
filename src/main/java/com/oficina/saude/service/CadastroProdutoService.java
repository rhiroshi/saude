package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Produto;
import com.oficina.saude.repository.Produtos;

@Service
public class CadastroProdutoService {

	@Autowired
	private Produtos produtos;
	
	public void salvar(Produto produto) {
		produtos.save(produto);
	} 
	
}
