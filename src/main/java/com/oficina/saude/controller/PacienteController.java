package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("/paciente/CadastroPaciente");
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(/*@Valid Paciente paciente,*/ BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo();
		}
		//cadastroCursoService.salvar(curso);
		attributes.addFlashAttribute("mensagem","Paciente cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/pacientes/novo");
	}
	
}
