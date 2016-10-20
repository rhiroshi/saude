package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Medico;
import com.oficina.saude.service.CadastroMedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private CadastroMedicoService cadastroMedicoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Medico medico) {
		ModelAndView mv = new ModelAndView("/medico/CadastroMedico");
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Medico medico, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(medico);
		}
		try {
			cadastroMedicoService.salvar(medico);
			attributes.addFlashAttribute("mensagem","Médico cadastrado com sucesso!");
			return new ModelAndView("redirect:/medicos/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/medicos/novo");
		} 
		
	}
	
}
