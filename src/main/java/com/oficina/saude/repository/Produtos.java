package com.oficina.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

}
