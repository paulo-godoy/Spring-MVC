package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.daos.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.TipoPreco;
import br.com.casadocodigo.loja.validation.ProdutoValidation;

@Controller //utilizado para informar o spring que a classe HomeController é a que controla então é utilizado o @Controller
@RequestMapping("produtos")
public class ProdutosController {
	@Autowired //nessa linha o Spring coloca o produto DAO aqui dentro
	private ProdutoDAO produtoDao;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProdutoValidation());
	}
	
	//Aqui é o endereço que o HomeController vai atender a /.
	@RequestMapping("/form") //mapeia o request do usuario para /produtos/form
	public ModelAndView form() {
		ModelAndView modelAndView = new ModelAndView("produtos/form");// serve para adicionar um atributo nesse caso o preço
		modelAndView.addObject("tipos", TipoPreco.values()); //essa linha pega todos os precos do array e leva para o forEach da pagina form.jsp
		 
		return modelAndView;
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView grava(@Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes) {
		
		//O if abaixo verifica se ouve algum erro. no preenchimento do formulario.
		if (result.hasErrors()) {
			return form();
		}
		
		produtoDao.gravar(produto);
		redirectAttributes.addFlashAttribute("sucesso", "Dados enviados com sucesso!");
		return new ModelAndView("redirect:produtos"); //essa linha depois do post evita reenviar o formulario com o F5
    }
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Produto> produtos = produtoDao.listar();
		ModelAndView modelAndView = new ModelAndView("produtos/lista");
		modelAndView.addObject("produtos", produtos);
		return modelAndView;
	}
	

}
