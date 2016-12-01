package com.oficina.saude.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oficina.saude.model.Roles;
import com.oficina.saude.repository.Pacientes;
import com.oficina.saude.repository.Prontuarios;

@Controller
@RequestMapping("/index")
public class IndexController {

	@Autowired
	private Pacientes pacientes;
	
	@Autowired
	private Prontuarios consultas;
	
	@RequestMapping
	public ModelAndView novo() {
		SecurityContext context = SecurityContextHolder.getContext();
		ModelAndView mv;
		if (context.getAuthentication().getAuthorities().equals(Roles.PACIENTE)) {
			mv = new ModelAndView("alterar link");
		} else {
			java.util.Date udata = new java.util.Date();
			Date data = new Date(udata.getTime());
			mv = new ModelAndView("/index/Index");
			mv.addObject("pacientesCadastrados", pacientes.count());
			mv.addObject("consultasHoje", consultas.countByData(data));
		}
		return mv;
	}
	
}
