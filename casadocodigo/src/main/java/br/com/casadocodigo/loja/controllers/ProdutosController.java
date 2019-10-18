package br.com.casadocodigo.loja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;

@Controller //utilizado para informar o spring que a classe HomeController é a que controla então é utilizado o @Controller
public class ProdutosController {
	@Autowired //nessa linha o Spring coloca o produto DAO aqui dentro
	private ProdutoDAO produtoDao;
	
	//Aqui é o endereço que o HomeController vai atender a /.
	@RequestMapping("/produtos/form") //mapeia o request do usuario para /produtos/form
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");// serve para adicionar um atributo nesse caso o preço
		modelAndView.addObject("tipos", TipoPreco.values()); //essa linha pega todos os precos do array e leva para o forEach da pagina form.jsp
		 
		return modelAndView;
	}
	
	
	@RequestMapping(value="/produtos", method=RequestMethod.POST)
	public String grava(Produto produto) {
		
		System.out.println(produto);
		produtoDao.gravar(produto);
        return "/produtos/ok";
    }
	
	@RequestMapping(value="/produtos", method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
	

}
