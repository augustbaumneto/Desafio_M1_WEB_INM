/**
 * 
 */
package br.com.inm.saucedemo.modelos;

import java.math.BigDecimal;

/**
 * 
 * Classe que representa os produtos da página de inventário
 * 
 * @author August Neto
 *
 */
public final class Produto {

	private String nome_produto;
	private String localizador_nome_produto;
	private String localizador_link;
	private String descricao_produto;
	private String localizador_descricao;
	private BigDecimal valor;
	private String localizador_valor;
	private String localizador_botao_adicionar;
	private String localizador_botao_remover;
	
	
	/**
	 * Construtor completo
	 * 
	 * @param localizador_nome_produto
	 * @param localizador_link
	 * @param localizador_descricao
	 * @param localizador_valor
	 * @param localizador_botao_adicionar
	 * @param localizador_botao_remover
	 */
	
	public Produto(String localizador_nome_produto, String localizador_link, String localizador_descricao,
			 String localizador_valor, String localizador_botao_adicionar, String localizador_botao_remover) {
		this.nome_produto = null;
		this.localizador_nome_produto = localizador_nome_produto;
		this.localizador_link = localizador_link;
		this.descricao_produto = null;
		this.localizador_descricao = localizador_descricao;
		this.valor = BigDecimal.ZERO;
		this.localizador_valor = localizador_valor;
		this.localizador_botao_adicionar = localizador_botao_adicionar;
		this.localizador_botao_remover = localizador_botao_remover;
	}
	
	/**
	 * Construtor semo botão adicionar para ser utilizando na CartPage
	 * 
	 * @param localizador_nome_produto
	 * @param localizador_link
	 * @param localizador_descricao
	 * @param localizador_valor
	 * @param localizador_botao_remover
	 */
	
	public Produto(String localizador_nome_produto, String localizador_link, String localizador_descricao,
			 String localizador_valor, String localizador_botao_remover) {
		
		this(localizador_nome_produto, localizador_link, localizador_descricao,
			 localizador_valor, null, localizador_botao_remover);
	}
	
	/**
	 * @return the nome_produto
	 */
	public String getNome_produto() {
		return nome_produto;
	}

	/**
	 * @param nome_produto the nome_produto to set
	 */
	public void setNome_produto(String nome_produto) {
		this.nome_produto = nome_produto;
	}

	/**
	 * @return the localizador_link
	 */
	public String getLocalizador_link() {
		return localizador_link;
	}

	/**
	 * @param localizador_link the localizador_link to set
	 */
	public void setLocalizador_link(String localizador_link) {
		this.localizador_link = localizador_link;
	}

	/**
	 * @return the descricao_produto
	 */
	public String getDescricao_produto() {
		return descricao_produto;
	}

	/**
	 * @param descricao_produto the descricao_produto to set
	 */
	public void setDescricao_produto(String descricao_produto) {
		this.descricao_produto = descricao_produto;
	}

	/**
	 * @return the localizador_descrição
	 */
	public String getLocalizador_descricao() {
		return localizador_descricao;
	}

	/**
	 * @param localizador_descrição the localizador_descrição to set
	 */
	public void setLocalizador_descrição(String localizador_descricao) {
		this.localizador_descricao = localizador_descricao;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(String valor) {
		
		this.valor = new BigDecimal(retiraCifrao(valor));
	}

	/**
	 * @return the localizador_valor
	 */
	public String getLocalizador_valor() {
		return localizador_valor;
	}

	/**
	 * @param localizador_valor the localizador_valor to set
	 */
	public void setLocalizador_valor(String localizador_valor) {
		this.localizador_valor = localizador_valor;
	}

	/**
	 * @return the localizador_botao
	 */
	public String getLocalizador_botao() {
		return localizador_botao_adicionar;
	}

	/**
	 * @param localizador_botao the localizador_botao to set
	 */
	public void setLocalizador_botao(String localizador_botao) {
		this.localizador_botao_adicionar = localizador_botao;
	}

	/**
	 * @return the localizador_botao_remover
	 */
	public String getLocalizador_botao_remover() {
		return localizador_botao_remover;
	}

	/**
	 * @param localizador_botao_remover the localizador_botao_remover to set
	 */
	public void setLocalizador_botao_remover(String localizador_botao_remover) {
		this.localizador_botao_remover = localizador_botao_remover;
	}

	/**
	 * @return the localizador_nome_produto
	 */
	public String getLocalizador_nome_produto() {
		return localizador_nome_produto;
	}

	/**
	 * @param localizador_nome_produto the localizador_nome_produto to set
	 */
	public void setLocalizador_nome_produto(String localizador_nome_produto) {
		this.localizador_nome_produto = localizador_nome_produto;
	}
	
	/**
	 * Retira o cifrão do valor
	 * @param valor
	 * @return
	 */
	private String retiraCifrao(String valor) {
		if(valor.contains("$")) {
			return valor.substring(1);
		}else {
			return valor;
		}
	}
	
	/**
	 * Verifica se os dados nome, descrição e valores são iguais nos dois produtos, caso algum seja 
	 *    diferente retorna false.
	 * 
	 * @param produto
	 * @return
	 */
	public boolean comparaDadosTextoCom(Produto produto) {
		
		return nome_produto.equals(produto.getNome_produto())&&
				descricao_produto.equals(produto.getDescricao_produto())&&
				valor.compareTo(produto.getValor())==0;
	}
	
}
