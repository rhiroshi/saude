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

import com.oficina.saude.model.Medico;
import com.oficina.saude.model.Paciente;
import com.oficina.saude.repository.Medicos;
import com.oficina.saude.service.CadastroMedicoService;
import com.oficina.saude.service.CadastroUsuarioService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private CadastroMedicoService cadastroMedicoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Medicos medicos;
	
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
			cadastroUsuarioService.salvar(medico.getUsuario());
			cadastroMedicoService.salvar(medico);
			attributes.addFlashAttribute("mensagem","Médico cadastrado com sucesso!");
			return new ModelAndView("redirect:/medicos/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/medicos/novo");
		} 
		
	}


	@RequestMapping("/edit/{cpf}")
	public ModelAndView edicao(@PathVariable("cpf") Medico medico) {
		ModelAndView mv = new ModelAndView("/medico/cadastroMedico"); 
		mv.addObject(medico);
		return mv;
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ModelAndView listaMedicos(){
		ModelAndView mv = new ModelAndView("/listagem/listarMedicos");
		mv.addObject("medicos", medicos.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/excluir/{cpf}", method = RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long cpf, RedirectAttributes attributes) {
		cadastroMedicoService.excluir(cpf);
		attributes.addFlashAttribute("mensagem", "Médico excluido");
		return new ModelAndView("redirect:/medicos/lista");
	}
	
}
