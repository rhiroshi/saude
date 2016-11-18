package com.oficina.saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;
import com.oficina.saude.repository.Prontuarios;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private Prontuarios prontuarios;
	
	@RequestMapping("/atender")
	public ModelAndView atender() {
		ModelAndView mv = new ModelAndView("consulta/AtendimentoConsulta");
		return mv;
	}
	
	@RequestMapping("/pendentes")
	public ModelAndView pendentes() {
		ModelAndView mv = new ModelAndView("consulta/ProntuariosPendentes");
		mv.addObject("prontuarios", prontuarios.findByStatus(Status.AGUARDANDO));
		return mv;
	}
	
	@RequestMapping(value = "/cancelar/{id}", method = RequestMethod.GET)
	public ModelAndView cancelar(@PathVariable Long id, RedirectAttributes attributes) {
		Prontuario prontuario = prontuarios.findOne(id);
		prontuario.setStatus(Status.CANCELADO);
		System.out.println("teste : ");
		System.out.println("cancelando: " + prontuarios.save(prontuario));
		return new ModelAndView("redirect:/consulta/pendentes");
	}
	
}
