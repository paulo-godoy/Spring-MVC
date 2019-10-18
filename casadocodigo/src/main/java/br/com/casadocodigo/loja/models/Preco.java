package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable //esse linha informa que o preço vai ser adicionado dentro do produto
public class Preco {
	
	private BigDecimal valor;
	private TipoPreco tipo;
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public TipoPreco getTipo() {
		return tipo;
	}
	public void setTipo(TipoPreco tipo) {
		this.tipo = tipo;
	}
	
	
	
}
