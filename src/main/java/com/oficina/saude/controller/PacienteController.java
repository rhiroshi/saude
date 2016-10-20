package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.service.CadastroPacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private CadastroPacienteService cadastroPacienteService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Paciente paciente) {
		ModelAndView mv = new ModelAndView("/paciente/CadastroPaciente");
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Paciente paciente, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(paciente);
		}
		try {
			cadastroPacienteService.salvar(paciente);
			attributes.addFlashAttribute("mensagem","Paciente cadastrado com sucesso!");
			return new ModelAndView("redirect:/pacientes/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/pacientes/novo");
		} 
		
	}
	
}
