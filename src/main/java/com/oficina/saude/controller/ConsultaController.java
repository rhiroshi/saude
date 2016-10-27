package com.oficina.saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@RequestMapping("/atender")
	public ModelAndView atender() {
		ModelAndView mv = new ModelAndView("consulta/AtendimentoConsulta");
		return mv;
	}
	
	@RequestMapping("/pendentes")
	public ModelAndView pendentes() {
		ModelAndView mv = new ModelAndView("consulta/ProntuariosPendentes");
		
		return mv;
	}
	
}
