package br.com.casadocodigo.loja;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//utilizado para informar o spring que a classe HomeController é a que controla então é utilizado o @Controller
@Controller
public class HomeController {
	
	//Aqui é o endereço que o HomeController vai atender a /.
	@RequestMapping("/") //mapeia o request do usuario para /
	public String index() {
		return "home";
	}
	

}
