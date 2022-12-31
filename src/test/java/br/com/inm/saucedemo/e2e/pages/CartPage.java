/**
 * 
 */
package br.com.inm.saucedemo.e2e.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Classe Page Objects da página de carrinho
 * 
 * @author August Neto
 *
 */
public class CartPage extends ObjectPageBase {

	private final static String URL_PAGINA_CARRINHO = "https://www.saucedemo.com/cart.html";
	
	private final static String CSSSELECTOR_LABEL_YOURCART = "#header_container .title";
	
	
	
	
	/**
	 * Construtor padrão
	 * @param driver
	 * @param navegador
	 */
	public CartPage(WebDriver driver) {
		super(driver, null);

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
	
	public boolean verificaItens(List<String> listacompras) {
		
		return false;
	}
	
}
