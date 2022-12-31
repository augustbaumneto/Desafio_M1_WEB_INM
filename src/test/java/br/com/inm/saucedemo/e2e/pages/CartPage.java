/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.inm.saucedemo.modelos.Produto;

/**
 * Classe Page Objects da página de carrinho
 * 
 * @author August Neto
 *
 */
public class CartPage extends ObjectPageBase {

	//Produtos adicionados
	private List<Produto> produtosadicionados;
	//Produtos exibidos
	private List<Produto> produtosexibidos;
	
	private final static int TAMANHOMAX_LISTAPRODUTOS = 6;
	
	private final static String URL_PAGINA_CARRINHO = "https://www.saucedemo.com/cart.html";
	
	private final static String CSSSELECTOR_LABEL_YOURCART = "#header_container .title";
	
	//Localizadores da lista de produtos
	private final static String BASE_LISTA_PROD = ".cart_item:nth-child(";
	
	private final static String CSS_SUFIXO_LISTA_PROD_NOME = " .inventory_item_name";
	private final static String CSS_SUFIXO_LISTA_PROD_LINK = " a";
	private final static String CSS_SUFIXO_LISTA_PROD_DESCRICAO = " .inventory_item_desc";
	private final static String CSS_SUFIXO_LISTA_PROD_PRECO = " .inventory_item_price";
	private final static String CSS_SUFIXO_LISTA_PROD_BOTAO_REMOVER = " button";
	
	//Primeiro item da lista
	
	
	/**
	 * Construtor padrão
	 * @param driver
	 * @param produtosadicionados lista de produtos adicionados no carrinho
	 */
	public CartPage(WebDriver driver, List<Produto> produtosadicionados) {
		super(driver, null);
		this.produtosadicionados=produtosadicionados;
		constroiListaProdutosExibidos();
	}

	private void constroiListaProdutosExibidos() {
		produtosexibidos= new ArrayList<>();
		
		for(int i=3; i<=2+TAMANHOMAX_LISTAPRODUTOS;i=i+1) {
			String localizadoritem = BASE_LISTA_PROD+i+")";
			if(elementoEstaPresente(By.cssSelector(localizadoritem))) {
				Produto produto = new Produto(localizadoritem+CSS_SUFIXO_LISTA_PROD_NOME,
						localizadoritem+CSS_SUFIXO_LISTA_PROD_LINK, 
						localizadoritem+CSS_SUFIXO_LISTA_PROD_DESCRICAO,
						localizadoritem+CSS_SUFIXO_LISTA_PROD_PRECO,
						localizadoritem+CSS_SUFIXO_LISTA_PROD_BOTAO_REMOVER);
				//Captura os dados de texto da tela
				String txtnome = driver.findElement(By.cssSelector(produto.getLocalizador_nome_produto())).getText();
				produto.setNome_produto(txtnome);
				String txtdescricao = driver.findElement(By.cssSelector(produto.getLocalizador_descricao())).getText();
				produto.setDescricao_produto(txtdescricao);
				String txtvalor = driver.findElement(By.cssSelector(produto.getLocalizador_valor())).getText();
				produto.setValor(txtvalor);
				
				produtosexibidos.add(produto);
				
			} else {
			
				break;
			}
		}
		
	}
	
	/**
	 * Verifica se esta na página do carrinho
	 * @return
	 */
	public boolean ePaginaCarrinho() {
		return ePaginaAtual(URL_PAGINA_CARRINHO);
	}
	
	/**
	 * Verifica se o label "Your Cart" esta presente na página
	 * @return
	 */
	public boolean verificaTextoSeuCarrinho() {
		return elementoEstaPresente(By.cssSelector(CSSSELECTOR_LABEL_YOURCART));
	}
	
	/**
	 * Verifica se os produtos adicionados são exibidas na tela e se estão na ordem correta e 
	 *    se os dados são os mesmos da tela de inventário.
	 * 
	 * @return
	 */
	public boolean verificaItensNoCarrinho() {
		
		if (produtosadicionados.size()!=produtosexibidos.size())
			return false;
		
		for (int i=0; i<produtosexibidos.size();i=i+1) {
			if (!produtosexibidos.get(i).comparaDadosTextoCom(produtosadicionados.get(i))) {
				return false;
			}

		}
		return true;
	}
	
}
