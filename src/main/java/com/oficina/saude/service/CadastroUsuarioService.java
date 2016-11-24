package com.oficina.saude.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oficina.saude.model.Usuario;
import com.oficina.saude.repository.Usuarios;

@Service
public class CadastroUsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void salvar(Usuario usuario) {
		
		usuario.setSenha(this.passwordEncoder.encode(usuario.getSenha()));
		//usuario.setConfirmacaoSenha(usuario.getSenha());
		usuarios.save(usuario);
	}
	
}
