package com.oficina.saude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oficina.saude.model.Usuario;
import com.oficina.saude.repository.helper.UsuariosQueries;

public interface Usuarios extends JpaRepository<Usuario, String>, UsuariosQueries {

	
}
