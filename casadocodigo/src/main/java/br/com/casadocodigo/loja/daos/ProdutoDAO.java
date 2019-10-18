package br.com.casadocodigo.loja.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;

@Repository //Essa linha faz com que o Spring conheca o nosso ProdutoDAO
@Transactional // essa linha iforma para o Spring que ele tem que cuidar dessa transação. essa referencia vem do JPAConfiguration.java
public class ProdutoDAO {
	
	
	@PersistenceContext //pede para o spring injetar e gerencia o EntityManger pra gente
	private EntityManager manager;  //O EntityManager ´o gerenciador para gravar dados no banco
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}

}
