package com.oficina.saude.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Paciente;
import com.oficina.saude.repository.Pacientes;
import com.oficina.saude.service.CadastroPacienteService;
import com.oficina.saude.service.CadastroUsuarioService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private CadastroPacienteService cadastroPacienteService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Pacientes pacientes;
	
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
			cadastroUsuarioService.salvar(paciente.getUsuario());
			cadastroPacienteService.salvar(paciente);
			attributes.addFlashAttribute("mensagem","Paciente cadastrado com sucesso!");
			return new ModelAndView("redirect:/pacientes/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/pacientes/novo");
		} 
		
	}
	
	@RequestMapping(value = "/pesquisa" , method = RequestMethod.POST)
	public List<Paciente> pesquisarPaciente(@RequestParam String nome) {
		List<Paciente> pacientes = cadastroPacienteService.pesquisar(nome);
	
		return pacientes;
	}
	
	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ModelAndView listaPacientes(){
		System.out.println("asd");
		ModelAndView mv = new ModelAndView("/listagem/listarPacientes");
		mv.addObject("pacientes", pacientes.findAll());
		return mv;
	}
}
