package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;

@Controller
@RequestMapping("/prontuarios")
public class ProntuarioController {
	
	

	@RequestMapping("/novo")
	public ModelAndView novo(Prontuario prontuario) {
		ModelAndView mv = new ModelAndView("prontuario/CadastroProntuario");
		mv.addObject("listaStatus", Status.values());
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView agendar(@Valid Prontuario prontuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(prontuario);
		}
		try {
			System.out.println("nome > " + prontuario.getPaciente().getNome());
			System.out.println("status > " + prontuario.getStatus());
			//cadastroFarmaceuticoService.salvar(farmaceutico);
			attributes.addFlashAttribute("mensagem","Consulta agendada com sucesso!");
			return new ModelAndView("redirect:/prontuarios/novo");
		} catch (IllegalArgumentException e) {
			return new ModelAndView("redirect:/prontuarios/novo");
		} 
		
	}

	
}
