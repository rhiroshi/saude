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
import com.oficina.saude.model.Receita;
import com.oficina.saude.model.Status;
import com.oficina.saude.repository.Consultas;
import com.oficina.saude.repository.Medicos;
import com.oficina.saude.repository.Prontuarios;
import com.oficina.saude.repository.Receitas;

@Controller
@RequestMapping("/consulta")
public class ConsultaController {

	@Autowired
	private Prontuarios prontuarios;
	
	@Autowired
	private Medicos medicos;
	
	@Autowired
	private Receitas receitas;
	
	@Autowired
	private Consultas consultas;
	
	@RequestMapping(value = "/atender/{id}", method = RequestMethod.GET)
	public ModelAndView atender(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("consulta/AtendimentoConsulta");
		SecurityContext context = SecurityContextHolder.getContext();
		Consulta consulta = new Consulta();
		consulta.setMedico(medicos.findOneByUsuarioEmail(context.getAuthentication().getName()));
		consulta.setProntuario(prontuarios.findOne(id));

		mv.addObject("consulta", consulta);
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
		Prontuario prontuario = consulta.getProntuario();
		prontuario.setStatus(Status.ATENDIDO);
		consulta.setProntuario(prontuario);
		Receita receita = receitas.findOne(consulta.getReceita().getCodigo());
		receita.setConsulta(consulta);
		consultas.save(consulta);
		Receita rec = receitas.save(receita);
		consulta.setReceita(rec);
		consultas.save(consulta);
		
		return new ModelAndView("redirect:/consulta/pendentes");
	}
	
}
