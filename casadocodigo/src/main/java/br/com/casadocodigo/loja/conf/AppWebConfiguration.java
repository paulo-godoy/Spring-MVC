package br.com.casadocodigo.loja.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.casadocodigo.loja.controllers.HomeController;
import br.com.casadocodigo.loja.daos.ProdutoDAO;


@EnableWebMvc //Informa o Spring que vai ser utilizado a parte WebMVC dele
@ComponentScan(basePackageClasses = {HomeController.class, ProdutoDAO.class})  //Aqui é utilizado para o spring encontrar onde está os controllers

public class AppWebConfiguration {

	@Bean //Informa que esse metodo vai usar uma classe gerenciado pelo Spring com o @Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}

}
