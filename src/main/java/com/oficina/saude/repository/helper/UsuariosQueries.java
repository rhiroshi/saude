package com.oficina.saude.repository.helper;

import java.util.Optional;

import com.oficina.saude.model.Usuario;

public interface UsuariosQueries {

	public Optional<Usuario> porEmail(String email);
	
}
