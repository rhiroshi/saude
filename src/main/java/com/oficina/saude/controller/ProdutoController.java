package com.oficina.saude.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
			if (produto.getCodigo() == null) {
				produto.setEstoque(0);				
			}
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
		mv.addObject("produtos", cadastroProdutoService.findAllOrdenado());	
		return mv;
	}

	@RequestMapping(value = "/pesquisa" , method = RequestMethod.GET)
	public List<Produto> pesquisar(@RequestParam String nome) {
		return cadastroProdutoService.pesquisar(nome);
	}
	
	@RequestMapping(value = "/abastecer", method=RequestMethod.POST)
	public ResponseEntity<?> abastecer(Long codigo, Integer estoque){
		Produto produto = produtos.findOne(codigo);
		produto.setEstoque(estoque);
		produtos.save(produto);
		
		return ResponseEntity.ok(produto);
	}
	
	@RequestMapping(value = "/editar/{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Produto produto) {
		ModelAndView mv = new ModelAndView("/produto/CadastroProduto");	
		mv.addObject(produto);
		return mv;
	}
}
