/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	
	//Tamanho máximo de itens possíveis na tela
	private final static int TAMANHOMAX_LISTAPRODUTOS = 6;
	//Primeira criança no CSS da lista de itens exibidos
	private final static int PRIMEIRO_ITEM_DA_LISTA_CSS = 3;
	
	private final static String URL_PAGINA_CARRINHO = "https://www.saucedemo.com/cart.html";
	
	private final static String CSSSELECTOR_LABEL_YOURCART = "#header_container .title";
	private final static String ID_BOTAO_CHECKOUT = "checkout";
	
	//Localizadores da lista de produtos
	private final static String CSS_BASE_ITEMLISTA_PROD = ".cart_item"; //Sem nth
	
	private final static String CSS_SUFIXO_LISTA_PROD_NOME = " .inventory_item_name";
	private final static String CSS_SUFIXO_LISTA_PROD_LINK = " a";
	private final static String CSS_SUFIXO_LISTA_PROD_DESCRICAO = " .inventory_item_desc";
	private final static String CSS_SUFIXO_LISTA_PROD_PRECO = " .inventory_item_price";
	private final static String CSS_SUFIXO_LISTA_PROD_BOTAO_REMOVER = " button";
	
	private static final String MSG_TITULO = "YOUR CART";
	
	
	/**
	 * Construtor padrão
	 * @param driver
	 * @param produtosadicionados lista de produtos adicionados no carrinho
	 */
	public CartPage(WebDriver driver, List<Produto> produtosadicionados) {
		super(driver, null);
		this.produtosadicionados=produtosadicionados;
		this.produtosexibidos = constroiListaProdutosExibidos(TAMANHOMAX_LISTAPRODUTOS,
					PRIMEIRO_ITEM_DA_LISTA_CSS,CSS_BASE_ITEMLISTA_PROD, CSS_SUFIXO_LISTA_PROD_NOME,
					CSS_SUFIXO_LISTA_PROD_LINK,	CSS_SUFIXO_LISTA_PROD_DESCRICAO,
					CSS_SUFIXO_LISTA_PROD_PRECO, CSS_SUFIXO_LISTA_PROD_BOTAO_REMOVER);
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
		By localizadortitulo = By.cssSelector(CSSSELECTOR_LABEL_YOURCART);
		
		return verificaSeMensagemEApresentadaLocalizador(localizadortitulo, MSG_TITULO);
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

	/**
	 * Inicia o procedimento de checkout clicando no botão checkout
	 */
	public CheckoutInformacionPage iniciarCheckout() {
		WebElement botaocheckout = driver.findElement(By.id(ID_BOTAO_CHECKOUT));
		botaocheckout.click();
		
		return new CheckoutInformacionPage(driver, produtosexibidos);
	}
	
}
