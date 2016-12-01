package com.oficina.saude.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oficina.saude.model.Consulta;
import com.oficina.saude.model.Prontuario;
import com.oficina.saude.model.Status;
import com.oficina.saude.repository.Medicos;
import com.oficina.saude.repository.Prontuarios;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private Prontuarios prontuarios;
	
	@Autowired
	private Medicos medicos;
	
	@RequestMapping(value = "/atender/{id}", method = RequestMethod.GET)
	public ModelAndView atender(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("consulta/AtendimentoConsulta");
		SecurityContext context = SecurityContextHolder.getContext();
		
		mv.addObject("medicos", medicos.findOneByUsuarioEmail(context.getAuthentication().getName()));
		mv.addObject("prontuarios", prontuarios.findOne(id));
		mv.addObject("consulta", new Consulta());
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
		prontuarios.save(prontuario);
		return new ModelAndView("redirect:/consulta/pendentes");
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public ModelAndView salvar(Consulta consulta, RedirectAttributes attributes) {
		SecurityContext context = SecurityContextHolder.getContext();
		consulta.setMedico(medicos.findOneByUsuarioEmail(context.getAuthentication().getName()));
		System.out.println("medico: " + consulta.getMedico().getCpf());
		System.out.println("prontu: " + consulta.getProntuario().getId());
		System.out.println("observa: " + consulta.getObservacao());
		return new ModelAndView("redirect:/consulta/pendentes");
	}
	
}
