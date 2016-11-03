package com.oficina.saude.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/prontuarios")
public class ProntuarioController {

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("prontuario/CadastroProntuario");
		
		return mv;
	}
	
}
