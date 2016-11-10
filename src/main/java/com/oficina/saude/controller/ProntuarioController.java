package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;
import com.oficina.saude.repository.Prontuarios;
import com.oficina.saude.service.CadastroProntuarioService;

@Controller
@RequestMapping("/prontuarios")
public class ProntuarioController {
	
	@Autowired
	private CadastroProntuarioService cadastroProntuarioService;
	
	@Autowired
	private Prontuarios prontuarios;

	@RequestMapping("/novo")
	public ModelAndView novo(Prontuario prontuario) {
		ModelAndView mv = new ModelAndView("prontuario/CadastroProntuario");
		mv.addObject("agendado", Status.AGENDADO);
		mv.addObject("prontuarios", prontuarios.findByStatus(Status.AGENDADO));
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView agendar(@Valid Prontuario prontuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(prontuario);
		}
		try {
			prontuario.setStatus(Status.AGENDADO);
			cadastroProntuarioService.salvar(prontuario);
			attributes.addFlashAttribute("mensagem","Consulta agendada com sucesso");
			return new ModelAndView("redirect:/prontuarios/novo");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/prontuarios/novo");
		} 	
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long id, RedirectAttributes attributes) {
		System.out.println("codigo > ");
		//cadastroProntuarioService.excluir(codigo);
		attributes.addFlashAttribute("mensagem","Consulta excluída");
		System.out.println("codigo > " + id);
		return "redirect:/prontuarios/novo";
	}
	
}
