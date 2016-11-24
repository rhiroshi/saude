package com.oficina.saude.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Farmaceutico;
import com.oficina.saude.service.CadastroFarmaceuticoService;
import com.oficina.saude.service.CadastroUsuarioService;

@Controller
@RequestMapping("/farmaceuticos")
public class FarmaceuticoController {

	@Autowired
	private CadastroFarmaceuticoService cadastroFarmaceuticoService;
	
	@Autowired
	private CadastroUsuarioService cadastroUsuarioService;
	
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
			cadastroUsuarioService.salvar(farmaceutico.getUsuario());
					
			cadastroFarmaceuticoService.salvar(farmaceutico);
			attributes.addFlashAttribute("mensagem","Farmaceutico cadastrado com sucesso!");
			return new ModelAndView("redirect:/farmaceuticos/novo");
		} catch (IllegalArgumentException e) {
			result.rejectValue("dataNascimento", null, e.getMessage());
			return new ModelAndView("redirect:/farmaceuticos/novo");
		} 
		
	}
	
}
