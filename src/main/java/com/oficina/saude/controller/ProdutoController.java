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

import com.oficina.saude.model.Produto;
import com.oficina.saude.repository.Produtos;
import com.oficina.saude.service.CadastroProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private Produtos produtos;
	
	@Autowired
	private CadastroProdutoService cadastroProdutoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Produto produto) {
		ModelAndView mv = new ModelAndView("/produto/CadastroProduto");
		
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(produto);
		}
		try {
			produto.setEstoque(0);
			produto.setReserva(0);
			cadastroProdutoService.salvar(produto);
			attributes.addFlashAttribute("mensagem","Medicamento cadastrado com sucesso!");
			return new ModelAndView("redirect:/produtos/novo");
		} catch (Exception e) {
			result.rejectValue("Erro", null, e.getMessage());
			return new ModelAndView("redirect:/produtos/novo");
		} 
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listaProdutos(){
		ModelAndView mv = new ModelAndView("/listagem/listarProdutos");
		mv.addObject("produtos", produtos.findAll());
		
		return mv;
	}

	@RequestMapping(value = "/pesquisa" , method = RequestMethod.GET)
	public List<Produto> pesquisar(@RequestParam String nome) {
		return cadastroProdutoService.pesquisar(nome);
	}
}
