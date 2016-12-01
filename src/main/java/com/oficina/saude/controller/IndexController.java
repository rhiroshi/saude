package com.oficina.saude.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

<<<<<<< Upstream, based on branch 'master' of https://github.com/brunexmg/saude.git
import com.oficina.saude.model.Paciente;
import com.oficina.saude.model.Usuario;
=======
>>>>>>> 157abaf v_7.5.0
import com.oficina.saude.repository.Consultas;
import com.oficina.saude.repository.Pacientes;
import com.oficina.saude.repository.Prontuarios;
import com.oficina.saude.repository.Usuarios;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private Pacientes pacientes;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Prontuarios prontuarios;
	
	@Autowired
	private Consultas consultas;
	
	@RequestMapping
	public ModelAndView novo() {
		ModelAndView mv;
		SecurityContext context = SecurityContextHolder.getContext();
		String comparar = context.getAuthentication().getAuthorities().toString();
		if(comparar.equals("[PACIENTE]")){
			String email = context.getAuthentication().getName().toString();
			Usuario usuario = usuarios.findOne(email);
			Paciente paciente = pacientes.findByUsuario(usuario);
			// --- PACIENTE ACESSANDO  ---
			mv = new ModelAndView("/index/IndexPaciente");
			mv.addObject("consultas", consultas.consultasRealizadas(paciente));
		}else{
			// --- OUTROS FUNCIONARIOS ---
			java.util.Date udata = new java.util.Date();
			Date data = new Date(udata.getTime());
			mv = new ModelAndView("/index/Index");
			mv.addObject("pacientesCadastrados", pacientes.count());
			mv.addObject("consultasHoje", prontuarios.countByData(data));
		}
		return mv;
	}
	
}
