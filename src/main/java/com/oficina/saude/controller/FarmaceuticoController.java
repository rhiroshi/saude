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

import com.oficina.saude.model.Farmaceutico;
import com.oficina.saude.model.Roles;
import com.oficina.saude.model.Usuario;
import com.oficina.saude.repository.Farmaceuticos;
import com.oficina.saude.service.CadastroFarmaceuticoService;
import com.oficina.saude.service.CadastroUsuarioService;

@Controller
@RequestMapping("/farmaceuticos")
public class FarmaceuticoController {

	@Autowired
	private CadastroFarmaceuticoService cadastroFarmaceuticoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
	@Autowired
	private Farmaceuticos farmaceuticos;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Farmaceutico farmaceutico) {
		ModelAndView mv = new ModelAndView("/farmaceutico/CadastroFarmaceutico");
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Farmaceutico farmaceutico, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(farmaceutico);
		}
		try {
			Usuario usuario = farmaceutico.getUsuario();
			usuario.setGrupo(Roles.FARMACO);
			cadastroUsuarioService.salvar(usuario);
					
			cadastroFarmaceuticoService.salvar(farmaceutico);
			attributes.addFlashAttribute("mensagem","Farmaceutico cadastrado com sucesso!");
			return new ModelAndView("redirect:/farmaceuticos/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/farmaceuticos/novo");
		} 
		
	}
	

	@RequestMapping("/edit/{cpf}")
	public ModelAndView edicao(@PathVariable("cpf") Farmaceutico farmaceutico) {
		ModelAndView mv = new ModelAndView("/farmaceutico/cadastroFarmaceutico"); 
		mv.addObject(farmaceutico);
		return mv;
	}
	

	@RequestMapping(value="/lista", method=RequestMethod.GET)
	public ModelAndView listaFarmaceuticos(){
		ModelAndView mv = new ModelAndView("/listagem/listarFarmacos");
		mv.addObject("farmacos", farmaceuticos.findAll());
		return mv;
	}
	
	@RequestMapping(value = "/excluir/{cpf}", method = RequestMethod.DELETE)
	public ModelAndView excluir(@PathVariable Long cpf, RedirectAttributes attributes) {
		cadastroFarmaceuticoService.excluir(cpf);
		attributes.addFlashAttribute("mensagem", "Farmaco excluido");
		return new ModelAndView("redirect:/farmaceuticos/lista");
	}
	
}
