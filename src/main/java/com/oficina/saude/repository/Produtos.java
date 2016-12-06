package com.oficina.saude.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {
	
	public List<Produto> findByNomeIgnoreCaseContaining(String nome);
	
	public List<Produto> findAllByOrderByCodigoAsc();
	
}
