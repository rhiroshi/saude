package com.oficina.saude.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.model.Usuario;

import com.oficina.saude.repository.Consultas;
import com.oficina.saude.repository.Pacientes;
import com.oficina.saude.repository.Prontuarios;
import com.oficina.saude.repository.Usuarios;

@Controller
public class IndexController {

	@Autowired
	private Pacientes pacientes;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private Prontuarios prontuarios;
	
	@Autowired
	private Consultas consultas;

	@RequestMapping("/index")
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

	@RequestMapping(value="/atestado/{codigo}",method = RequestMethod.GET)
	public ModelAndView atestado(@PathVariable Long codigo){
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("format", "pdf");
		parametros.put("codigo_consulta", codigo);
		return new ModelAndView("rel_atestado", parametros);
	}

	@RequestMapping(value="/receita/imprimir/{codigo}",method = RequestMethod.GET)
	public ModelAndView imprimeReceita(@PathVariable Long codigo){
		Map<String, Object> parametros = new HashMap<>();
		parametros.put("format", "pdf");
		parametros.put("consulta_codigo", codigo);
		return new ModelAndView("rel_medicamentos", parametros);
	}
	
	
	
}
