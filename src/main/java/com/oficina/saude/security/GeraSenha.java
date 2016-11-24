package com.oficina.saude.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeraSenha {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
	}
	
}
